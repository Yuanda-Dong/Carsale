package com.packt.carsale.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.packt.carsale.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository repository;

    public UserDetailsServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username);

        if (user.isPresent()) {
            var currentUser = user.get();
            var builder = User.withUsername(username).password(currentUser.getPassword()).roles(currentUser.getRole());
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }

}
