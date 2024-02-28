package com.avigail.company.dto;

import java.util.Date;

public class JobDTO {
    private int id;
    private String description;
    private Date endDate;
    private int employeeId;

    public JobDTO(int id, String description, Date endDate, int employeeId) {
        this.id = id;
        this.description = description;
        this.endDate = endDate;
        this.employeeId = employeeId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                ", employeeId=" + employeeId +
                '}';
    }
}
