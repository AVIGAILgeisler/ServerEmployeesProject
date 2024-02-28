package com.avigail.company.enums;

public enum ErrorType {
    GENERAL_ERROR(601, "General error", true),
    JOB_DOES_NOT_EXIST(602, "Job does not exist", false),
    EMPLOYEE_DOES_NOT_EXIST(603, "Employee does not exist", false),

    INVALID_ID(604, "Id must be positive", false),
    INVALID_NAME(605, "Name must contain at Least 2 chars and no more than 12", false),

    INVALID_JOB_DESCRIPTION(606, "Description must contain at Least 5 chars and no more than 40", false),
    INVALID_SALARY(607, "Salary must be positive or 0", false),
    INVALID_DATE(608, "Date cannot be null", false);


    private int errorNumber;
    private String errorMessage;
    private boolean isShowStackTrace;

    ErrorType(int errorNumber, String errorMessage, boolean isShowStackTrace) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.isShowStackTrace = isShowStackTrace;
    }

    ErrorType(int errorNumber, String errorMessage) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
    }

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public boolean isShowStackTrace() {
        return isShowStackTrace;
    }

}

