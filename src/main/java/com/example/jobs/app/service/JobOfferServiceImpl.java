package com.example.jobs.app.service;

import com.example.jobs.app.api.JobOfferService;
import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.dto.JobOfferDto;
import com.example.jobs.app.model.entity.JobOffer;
import com.example.jobs.app.model.entity.Person;
import com.example.jobs.app.model.entity.UserAccount;
import com.example.jobs.app.repository.JobOfferRepository;
import com.example.jobs.app.repository.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class JobOfferServiceImpl extends AbstractServiceImpl<JobOffer> implements JobOfferService {

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
        Person person = personRepository.getByUserAccount(userAccount.getId());
        JobOffer jobOffer = new JobOffer();
        jobOffer.setDescription(jobOfferDto.getDescription());
        jobOffer.setPerson(person);
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
}
