package com.avigail.company.logic;

import com.avigail.company.dal.IJobsDal;
import com.avigail.company.dto.JobDTO;
import com.avigail.company.entities.Job;
import com.avigail.company.enums.ErrorType;
import com.avigail.company.exceptions.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobsLogic {

    private IJobsDal iJobsDal;

    @Autowired
    private EmployeesLogic employeesLogic;


    @Autowired
    public JobsLogic(IJobsDal iJobsDal) {
        this.iJobsDal = iJobsDal;
    }


    public void createJob(Job job) throws ApplicationException {
        descriptionValidation(job.getDescription());
        dateValidation(job.getEndDate());
        employeesLogic.validateEmployeeExistence(job.getEmployee().getId());
        iJobsDal.save(job);
    }

    public void updateJob(Job job) throws ApplicationException {
        descriptionValidation(job.getDescription());
        dateValidation (job.getEndDate());
        employeesLogic.validateEmployeeExistence(job.getEmployee().getId());
        iJobsDal.save(job);
    }

    public void removeJob(int jobId) throws ApplicationException {
        idValidation(jobId);
        validateJobExistence(jobId);
        iJobsDal.deleteById(jobId);
    }

    public JobDTO getJobById(int jobId) throws ApplicationException {
        idValidation(jobId);
        validateJobExistence(jobId);
        return iJobsDal.findJobById(jobId);
    }

    public List<JobDTO> getAllJobs() throws ApplicationException {
        return iJobsDal.findAllJobs();
    }

    public List<JobDTO> getAllJobsByEmployeeId(int employeeId) throws ApplicationException {
        //Validate employee exist
        employeesLogic.validateEmployeeExistence(employeeId);
        return iJobsDal.findAllJobsByEmployeeId(employeeId);
    }

    public List<JobDTO> getJobByEndDate(Date endDate) throws ApplicationException {
        dateValidation(endDate);
        return iJobsDal.findJobByEndDate(endDate);
    }

    public List<JobDTO> getJobByEndDateBetween(Date startDate, Date endDate) throws ApplicationException {
        dateValidation(startDate);
        dateValidation(endDate);
        return iJobsDal.findJobByEndDateBetween(startDate, endDate);
    }


    //isExist
    void validateJobExistence(int jobId) throws ApplicationException {
        if (!iJobsDal.existsById(jobId)) {
            throw new ApplicationException(ErrorType.JOB_DOES_NOT_EXIST);
        }
    }

    //validations
    private void idValidation(int jobId) throws ApplicationException {
        if (jobId <= 0) {
            throw new ApplicationException(ErrorType.INVALID_ID);
        }
    }

    private void descriptionValidation(String description) throws ApplicationException {
        if (description.length() < 5 || description.length() > 40) {
            throw new ApplicationException(ErrorType.INVALID_JOB_DESCRIPTION);
        }
    }

    private void dateValidation(Date date) throws ApplicationException {
        if (date == null) {
            throw new ApplicationException(ErrorType.INVALID_DATE);
        }
    }
}

