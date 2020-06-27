package com.example.jobs.app.controller;

import com.example.jobs.app.api.JobOfferService;
import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.dto.JobOfferDto;
import com.example.jobs.app.model.dto.JobOfferDtoDetails;
import com.example.jobs.app.model.dto.UsernameDto;
import com.example.jobs.app.model.entity.JobOffer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseBody
    public List<JobOffer> getAll() {
        return jobOfferService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public JobOfferDtoDetails getJobOffer(@PathVariable  Long id) {
        return jobOfferService.getJobOffer(id);
    }

    @PostMapping("/userOffers")
    @ResponseBody
    public List<JobOffer> getUserJobOffer(@RequestBody UsernameDto usernameDto) {
        try {
            return jobOfferService.getUserJobOffers(usernameDto.getUsername());
        } catch (UserNotFoundException e) {
            return null;
        }
    }

}
