package com.springsecurity.basicDatabaseAuthentication.service;

import com.springsecurity.basicDatabaseAuthentication.model.User;
import com.springsecurity.basicDatabaseAuthentication.model.UserDetailsCustom;
import com.springsecurity.basicDatabaseAuthentication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailsCustom(user.get());
    }
}
