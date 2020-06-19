package com.example.jobs.app.api;

import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.dto.JobOfferDto;
import com.example.jobs.app.model.entity.JobOffer;
import org.springframework.stereotype.Service;

@Service
public interface JobOfferService extends AbstractService<JobOffer> {
    void createJobOffer(JobOfferDto jobOfferDto) throws UserNotFoundException;
}
