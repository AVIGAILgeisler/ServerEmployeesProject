package com.avigail.company.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="NAME",nullable = false)
    private String name;
    @Column(name="SALARY",nullable = false)
    private double salary;
    @OneToMany (cascade=CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "employee")
    private List<Job> jobList;

    public Employee() {
    }

    public Employee(int id, String name, double salary, List<Job> jobList) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.jobList = jobList;
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

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

}
