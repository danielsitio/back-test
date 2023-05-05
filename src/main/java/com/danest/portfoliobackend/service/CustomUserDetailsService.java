package com.danest.portfoliobackend.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danest.portfoliobackend.domain.User;
import com.danest.portfoliobackend.domain.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFound = userRepository.findByUsername(username);
        if (userFound == null)
            throw new UsernameNotFoundException(username);
        return new org.springframework.security.core.userdetails.User(userFound.getUsername(), userFound.getPassword(),
                List.of());
    }

}
