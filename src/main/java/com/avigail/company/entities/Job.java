package com.avigail.company.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public Job() {
    }

    public Job(int id, String description, Date endDate, Employee employee) {
        this.id = id;
        this.description = description;
        this.endDate = endDate;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
