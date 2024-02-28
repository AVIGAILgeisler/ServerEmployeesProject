package com.avigail.company.dal;

import com.avigail.company.dto.JobDTO;
import com.avigail.company.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IJobsDal extends JpaRepository<Job, Integer> {

    @Query("SELECT NEW com.avigail.company.dto.JobDTO (j.id, j.description, j.endDate, j.employee.id) " +
            "FROM Job j WHERE j.id= :jobId")
    JobDTO findJobById(@Param("jobId") int jobId);

    @Query("SELECT NEW com.avigail.company.dto.JobDTO (j.id, j.description, j.endDate, j.employee.id) " +
            "FROM Job j")
    List<JobDTO> findAllJobs();

    @Query("SELECT NEW com.avigail.company.dto.JobDTO (j.id, j.description, j.endDate, j.employee.id) " +
            "FROM Job j WHERE j.employee.id= :employeeId")
    List<JobDTO> findAllJobsByEmployeeId(@Param("employeeId") int employeeId);


    @Query("SELECT NEW com.avigail.company.dto.JobDTO (j.id, j.description, j.endDate, j.employee.id) " +
            "FROM Job j WHERE j.endDate= :endDate")
    List<JobDTO> findJobByEndDate(@Param("endDate") Date endDate);

    @Query("SELECT NEW com.avigail.company.dto.JobDTO (j.id, j.description, j.endDate, j.employee.id) " +
            "FROM Job j WHERE j.endDate>= :startDate AND j.endDate>= :endDate")
    List<JobDTO> findJobByEndDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
