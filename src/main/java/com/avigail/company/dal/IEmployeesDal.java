package com.avigail.company.dal;

import com.avigail.company.dto.EmployeeDTO;
import com.avigail.company.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeesDal extends JpaRepository<Employee, Integer> {

    @Query("SELECT NEW com.avigail.company.dto.EmployeeDTO (e.id, e.name, e.salary) " +
            "FROM Employee e WHERE e.id= :employeeId")
    EmployeeDTO findEmployeeById(@Param("employeeId") int employeeId);

    @Query("SELECT NEW com.avigail.company.dto.EmployeeDTO (e.id, e.name, e.salary) " +
            "FROM Employee e WHERE e.name= :employeeName")
    EmployeeDTO findEmployeeByName(@Param("employeeName") String name);

    @Query("SELECT NEW com.avigail.company.dto.EmployeeDTO (e.id, e.name, e.salary) FROM Employee e")
    List<EmployeeDTO> findAllEmployees();

    @Query("SELECT NEW com.avigail.company.dto.EmployeeDTO (e.id, e.name, e.salary) " +
            "FROM Employee e WHERE e.name= :employeeName")
    List<EmployeeDTO> findAllEmployeesByName(@Param("employeeName") String name);

}