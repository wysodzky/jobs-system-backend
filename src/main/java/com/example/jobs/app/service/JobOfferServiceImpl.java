package com.example.jobs.app.service;

import com.example.jobs.app.api.JobOfferService;
import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.dto.JobOfferDto;
import com.example.jobs.app.model.dto.JobOfferDtoDetails;
import com.example.jobs.app.model.entity.JobOffer;
import com.example.jobs.app.model.entity.Person;
import com.example.jobs.app.model.entity.UserAccount;
import com.example.jobs.app.repository.JobOfferRepository;
import com.example.jobs.app.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobOfferServiceImpl implements JobOfferService {

    private JobOfferRepository jobOfferRepository;
    private UserAccountService userAccountService;
    private PersonRepository personRepository;


    public JobOfferServiceImpl(JobOfferRepository jobOfferRepository, UserAccountService userAccountService, PersonRepository personRepository) {
        this.jobOfferRepository = jobOfferRepository;
        this.userAccountService = userAccountService;
        this.personRepository = personRepository;
    }

    @Override
    public void createJobOffer(JobOfferDto jobOfferDto) throws UserNotFoundException {
        UserAccount userAccount = userAccountService.loadUserAccountByUsername(jobOfferDto.getUsername());
        Person person = userAccount.getPerson();
        JobOffer jobOffer = new JobOffer();
        jobOffer.setDescription(jobOfferDto.getDescription());
        jobOffer.setBenefits(jobOfferDto.getBenefits());
        jobOffer.setRequirements(jobOfferDto.getRequirements());
        jobOffer.setSalary(jobOfferDto.getSalary());
        jobOffer.setWorkHours(jobOfferDto.getWorkHours());
        jobOffer.setTitle(jobOfferDto.getTitle());
        jobOffer.setWorkType(jobOfferDto.getWorkType());
        jobOfferRepository.save(jobOffer);
        person.getJobOffers().add(jobOffer);
        personRepository.save(person);
    }

    @Override
    public List<JobOffer> getAll() {
        return jobOfferRepository.findAll();
    }

    @Override
    public JobOfferDtoDetails getJobOffer(Long id) {
        JobOffer jobOffer = jobOfferRepository.getOne(id);
        JobOfferDtoDetails jobOfferDtoDetails = new JobOfferDtoDetails();
        jobOfferDtoDetails.setTitle(jobOffer.getTitle());
        jobOfferDtoDetails.setDescription(jobOffer.getDescription());
        jobOfferDtoDetails.setBenefits(jobOffer.getBenefits());
        jobOfferDtoDetails.setSalary(jobOffer.getSalary());
        jobOfferDtoDetails.setRequirements(jobOffer.getRequirements());
        jobOfferDtoDetails.setWorkHours(jobOffer.getWorkHours());
        jobOfferDtoDetails.setWorkType(jobOffer.getWorkType());

        Long personId = personRepository.getPersonIdByJobOfferId(id);
        Person person = personRepository.getOne(personId);
        jobOfferDtoDetails.setFirstName(person.getFirstName());
        jobOfferDtoDetails.setLastName(person.getLastName());
        return jobOfferDtoDetails;
    }

    @Override
    public List<JobOffer> getUserJobOffers(String username) throws UserNotFoundException {
        UserAccount userAccount = userAccountService.loadUserAccountByUsername(username);
        Person person = userAccount.getPerson();
        return person.getJobOffers();
    }

    @Override
    public void deleteJobOffer(Long id) {
        Long personId = personRepository.getPersonIdByJobOfferId(id);
        Person person = personRepository.getOne(personId);

        List<JobOffer> jobList = person.getJobOffers();
        JobOffer jobToRemove = null;

        for (JobOffer jobOffer : jobList) {
            if (jobOffer.getId().equals(id)) {
                jobToRemove = jobOffer;
            }
        }

        if (jobToRemove != null) {
            jobList.remove(jobToRemove);
        }
        person.setJobOffers(jobList);

        personRepository.save(person);

        jobOfferRepository.deleteById(id);
    }
}
