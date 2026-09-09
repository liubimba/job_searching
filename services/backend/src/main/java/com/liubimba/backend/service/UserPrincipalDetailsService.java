package com.liubimba.backend.service;

import com.liubimba.backend.repository.UserRepository;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserPrincipalDetailsService implements UserDetailsService {
    protected UserRepository userRepository;

    UserPrincipalDetailsService(T userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @NullMarked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found user email: %s".formatted(username)));
    }
}
