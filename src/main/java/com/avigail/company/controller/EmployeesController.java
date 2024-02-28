package com.avigail.company.controller;

import com.avigail.company.dto.EmployeeDTO;
import com.avigail.company.entities.Employee;
import com.avigail.company.exceptions.ApplicationException;
import com.avigail.company.logic.EmployeesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private EmployeesLogic employeesLogic;

    @Autowired
    public EmployeesController(EmployeesLogic employeesLogic) {
        this.employeesLogic = employeesLogic;
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) throws ApplicationException {
        employeesLogic.createEmployee(employee);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) throws ApplicationException {
        employeesLogic.updateEmployee(employee);
    }

    @DeleteMapping("{employeeId}")
    public void removeEmployee(@PathVariable("employeeId") int employeeId) throws ApplicationException {
        employeesLogic.removeEmployee(employeeId);
    }
    @GetMapping("{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") int employeeId) throws ApplicationException {
        return employeesLogic.getEmployeeById(employeeId);
    }

    @GetMapping("/byEmployeeName")
    public EmployeeDTO getEmployeeByName(@RequestParam("employeeName") String employeeName) throws ApplicationException {
        return employeesLogic.getEmployeeByName(employeeName);
    }

    @GetMapping("/getAll")
    public List<EmployeeDTO> getAllEmployees() throws ApplicationException {
        return employeesLogic.getAllEmployees();
    }

    @GetMapping("/getAllByName")
    public List<EmployeeDTO> getAllEmployeesByName(@RequestParam("employeeName") String employeeName) throws ApplicationException {
        return employeesLogic.getAllEmployeesByName(employeeName);
    }
}
