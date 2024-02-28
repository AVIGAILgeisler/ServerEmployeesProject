package com.avigail.company.controller;

import com.avigail.company.dto.JobDTO;
import com.avigail.company.entities.Job;
import com.avigail.company.exceptions.ApplicationException;
import com.avigail.company.logic.JobsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
    @RequestMapping("/jobs")
    public class JobsController {

        private JobsLogic jobsLogic;

        @Autowired
        public JobsController(JobsLogic jobsLogic) {
            this.jobsLogic = jobsLogic;
        }

        @PostMapping
        public void createJob(@RequestBody Job job) throws ApplicationException {
            jobsLogic.createJob(job);
        }

        @PutMapping
        public void updateJob(@RequestBody Job job) throws ApplicationException {
            jobsLogic.updateJob(job);
        }

        @DeleteMapping("{jobId}")
        public void removeJob(@PathVariable("jobId") int jobId) throws ApplicationException {
            jobsLogic.removeJob(jobId);
        }

        @GetMapping("{jobId}")
        public JobDTO getJobById(@PathVariable("jobId") int jobId) throws ApplicationException {
            return jobsLogic.getJobById(jobId);
        }

        @GetMapping("/getAll")
        public List<JobDTO> getAllJobs() throws ApplicationException {
            return jobsLogic.getAllJobs();
        }

        @GetMapping("/byEmployeeId")
        public List<JobDTO> getAllJobsByEmployeeId(@RequestParam("employeeId") int employeeId) throws ApplicationException {
            return jobsLogic.getAllJobsByEmployeeId(employeeId);
        }

        @GetMapping("/byEndDate")
        public List<JobDTO> getJobByEndDate(@RequestParam("endDate") Date endDate) throws ApplicationException {
            return jobsLogic.getJobByEndDate(endDate);
        }

        @GetMapping("/byDatesBetween")
        public List<JobDTO> getJobByEndDateBetween(@RequestParam("startDate") Date startDate,
                                                   @RequestParam("endDate") Date endDate) throws ApplicationException {
            return jobsLogic.getJobByEndDateBetween(startDate, endDate);
        }
    }

