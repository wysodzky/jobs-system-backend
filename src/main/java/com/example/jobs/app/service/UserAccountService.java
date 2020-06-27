package com.example.jobs.app.service;

import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.entity.Authority;
import com.example.jobs.app.model.AuthorityType;
import com.example.jobs.app.model.entity.Person;
import com.example.jobs.app.model.entity.UserAccount;
import com.example.jobs.app.model.dto.UserDto;
import com.example.jobs.app.repository.AuthorityRepository;
import com.example.jobs.app.repository.PersonRepository;
import com.example.jobs.app.repository.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AuthorityRepository authorityRepository;
    private PersonRepository personRepository;

    public UserAccountService(UserAccountRepository userAccountRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthorityRepository authorityRepository,PersonRepository personRepository) {
        this.userAccountRepository = userAccountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authorityRepository = authorityRepository;
        this.personRepository = personRepository;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User loadUserByUsername(String username) throws UserNotFoundException {
       UserAccount userAccount = userAccountRepository.getByUsername(username).orElseThrow(UserNotFoundException::new);
       return new User(userAccount.getUsername(),userAccount.getPassword(),new ArrayList<>(userAccount.getAuthorities()));
    }

    public UserAccount loadUserAccountByUsername(String username) throws UserNotFoundException {
       return userAccountRepository.getByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    public void saveUser(UserDto userDto) {

        Person person = new Person();
        person.setFirstName(userDto.getFirstName());
        person.setLastName(userDto.getLastName());
        person.setPhoneNumber(userDto.getPhoneNumber());

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(userDto.getEmail());
        userAccount.setEmail(userDto.getEmail());
        userAccount.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userAccount = userAccountRepository.save(userAccount);

        Authority authority = new Authority();
        authority.setRole(AuthorityType.ROLE_USER);
        authority.setUserAccount(userAccount);

        authorityRepository.save(authority);

        userAccount.setAuthorities(new HashSet<Authority>() {{add(authority);}});

        userAccountRepository.save(userAccount);

        userAccount.setPerson(person);

        personRepository.save(person);


    }
}
