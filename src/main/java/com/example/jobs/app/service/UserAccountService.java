package com.example.jobs.app.service;

import com.example.jobs.app.exception.UserNotFoundException;
import com.example.jobs.app.model.entity.Authority;
import com.example.jobs.app.model.AuthorityType;
import com.example.jobs.app.model.entity.UserAccount;
import com.example.jobs.app.model.dto.UserDto;
import com.example.jobs.app.repository.UserAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class UserAccountService {
    private UserAccountRepository userAccountRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccountService(UserAccountRepository userAccountRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User loadUserByUsername(String username) throws UserNotFoundException {
       UserAccount userAccount = userAccountRepository.getByUsername(username).orElseThrow(UserNotFoundException::new);
       return new User(userAccount.getUsername(),userAccount.getPassword(),new ArrayList<>(userAccount.getAuthorities()));
    }
    public void saveUser(UserDto userDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(userDto.getUsername());
        userAccount.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        Authority authority = new Authority();
        authority.setRole(AuthorityType.ROLE_USER);
        userAccount.setAuthorities(new HashSet<Authority>() {{add(authority);}});
        userAccountRepository.save(userAccount);
    }
}
