package com.avigail.company.logic;

import com.avigail.company.dal.IEmployeesDal;
import com.avigail.company.dto.EmployeeDTO;
import com.avigail.company.entities.Employee;
import com.avigail.company.enums.ErrorType;
import com.avigail.company.exceptions.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesLogic {
    private IEmployeesDal iEmployeesDal;

    @Autowired
    private JobsLogic jobsLogic;

    @Autowired
    public EmployeesLogic(IEmployeesDal iEmployeesDal) {
        this.iEmployeesDal = iEmployeesDal;
    }


    public void createEmployee(Employee employee) throws ApplicationException {
        nameValidation(employee.getName());
        salaryValidation(employee.getSalary());
        iEmployeesDal.save(employee);
    }

    public void updateEmployee(Employee employee) throws ApplicationException {
        nameValidation(employee.getName());
        salaryValidation(employee.getSalary());
        iEmployeesDal.save(employee);
    }

    public void removeEmployee(int employeeId) throws ApplicationException {
        idValidation(employeeId);
        validateEmployeeExistence(employeeId);
        iEmployeesDal.deleteById(employeeId);
    }

    public EmployeeDTO getEmployeeById(int employeeId) throws ApplicationException {
        idValidation(employeeId);
        validateEmployeeExistence(employeeId);
        return iEmployeesDal.findEmployeeById(employeeId);
    }

    public EmployeeDTO getEmployeeByName(String employeeName) throws ApplicationException {
        validateEmployeeExistenceByName(employeeName);
        return iEmployeesDal.findEmployeeByName(employeeName);
    }

    public List<EmployeeDTO> getAllEmployees() throws ApplicationException {
        return iEmployeesDal.findAllEmployees();
    }

    public List<EmployeeDTO> getAllEmployeesByName(String employeeName) throws ApplicationException {
        return iEmployeesDal.findAllEmployeesByName(employeeName);
    }

    //returns employee with his jobs list -
//    public EmployeeDTO getEmployeeWithJobsList(int employeeId) throws ApplicationException {
//        idValidation(employeeId);
//        validateEmployeeExistence(employeeId);
//
//        String employeeName = iEmployeesDal.findEmployeeById(employeeId).getName();
//        double employeeSalary = iEmployeesDal.findEmployeeById(employeeId).getSalary();
//        List<JobDTO> employeeJobsList = jobsLogic.getAllJobsByEmployeeId(employeeId);
//
//        EmployeeDTO employee = new EmployeeDTO(employeeId, employeeName, employeeSalary , employeeJobsList);
//        return employee;
//    }


    //isExist
    void validateEmployeeExistence(int employeeId) throws ApplicationException {
        if (!iEmployeesDal.existsById(employeeId)) {
            throw new ApplicationException(ErrorType.EMPLOYEE_DOES_NOT_EXIST);
        }
    }

    //validations

    private void validateEmployeeExistenceByName(String employeeName) throws ApplicationException {
        if (iEmployeesDal.findEmployeeByName(employeeName) == null) {
            throw new ApplicationException(ErrorType.EMPLOYEE_DOES_NOT_EXIST);
        }
    }

    private void idValidation(int employeeId) throws ApplicationException {
        if (employeeId <= 0) {
            throw new ApplicationException(ErrorType.INVALID_ID);
        }
    }

    private void nameValidation(String name) throws ApplicationException {
        if (name.length() < 2 || name.length() > 15) {
            throw new ApplicationException(ErrorType.INVALID_NAME);
        }
    }

    private void salaryValidation(double salary) throws ApplicationException {
        if (salary < 0) {
            throw new ApplicationException(ErrorType.INVALID_SALARY);
        }
    }
}


