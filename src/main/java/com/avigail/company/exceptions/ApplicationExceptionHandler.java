package com.avigail.company.exceptions;

import com.avigail.company.dto.ServerErrorData;
import com.avigail.company.enums.ErrorType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ServerErrorData exceptionCustomerResponse(HttpServletResponse httpServletResponse, Exception e) {
        if (e instanceof ApplicationException) {
            int errorCode = ((ApplicationException) e).getErrorType().getErrorNumber();
            String errorMessage = ((ApplicationException) e).getErrorType().getErrorMessage();
            String errorType = String.valueOf(((ApplicationException) e).getErrorType());

            httpServletResponse.setStatus(errorCode);

            if (((ApplicationException) e).getErrorType().isShowStackTrace()) {
                e.printStackTrace();
            }

            ServerErrorData ErrorData = new ServerErrorData(errorCode, errorMessage,errorType);
            return ErrorData;
        }

        httpServletResponse.setStatus(601);

        ServerErrorData errorData = new ServerErrorData(601, "Something went wrong","GENERAL_ERROR");
        return errorData;
    }

}
