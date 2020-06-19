package com.example.jobs.app.controller;

import com.example.jobs.app.api.JobOfferService;
import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.dto.JobOfferDto;
import com.example.jobs.app.repository.JobOfferRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobOfferController {

    private JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }


    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity create(@RequestBody JobOfferDto jobOfferDto) {
        try {
            jobOfferService.createJobOffer(jobOfferDto);
            return ResponseEntity.ok().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
