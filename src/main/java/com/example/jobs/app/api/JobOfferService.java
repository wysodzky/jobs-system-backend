package com.example.jobs.app.api;

import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.dto.JobOfferDto;
import com.example.jobs.app.model.dto.JobOfferDtoDetails;
import com.example.jobs.app.model.entity.JobOffer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobOfferService {
    void createJobOffer(JobOfferDto jobOfferDto) throws UserNotFoundException;
    List<JobOffer> getAll();
    JobOfferDtoDetails getJobOffer(Long id);
    List<JobOffer> getUserJobOffers(String username) throws UserNotFoundException;
    void deleteJobOffer(Long id);
}
