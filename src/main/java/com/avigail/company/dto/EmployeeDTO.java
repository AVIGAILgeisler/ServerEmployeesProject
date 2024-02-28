package com.avigail.company.dto;

import java.util.List;

public class EmployeeDTO {
    private int id;
    private String name;
    private double salary;
    private List<JobDTO> jobsList;

    public EmployeeDTO(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public EmployeeDTO(int id, String name, double salary, List<JobDTO> jobsList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.jobsList = jobsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<JobDTO> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<JobDTO> jobsList) {
        this.jobsList = jobsList;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", jobsList=" + jobsList +
                '}';
    }
}
