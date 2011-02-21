package org.krall.preauth.dao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

public class InMemoryAuthenticationUserDetailsService extends InMemoryDaoImpl implements AuthenticationUserDetailsService {

    private UserDetailsService userDetailsService;

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(token.getName());
        if(userDetails == null) {
            throw new UsernameNotFoundException("Could not load user: " + token.getName());
        }
        return userDetails;
    }
}
