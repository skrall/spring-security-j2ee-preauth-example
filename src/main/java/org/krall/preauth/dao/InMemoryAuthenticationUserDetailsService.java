package org.krall.preauth.dao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class InMemoryAuthenticationUserDetailsService implements AuthenticationUserDetailsService {

    @Override
    public UserDetails loadUserDetails(Authentication token) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        if("jimi".equalsIgnoreCase(token.getName())) {
            userDetails = getAdminUser(token.getName());
        } else if ("fred".equalsIgnoreCase(token.getName())) {
            userDetails = getRegularUser(token.getName());
        }
        if(userDetails == null) {
            throw new UsernameNotFoundException("Could not load user: " + token.getName());
        }
        return userDetails;
    }

    private UserDetails getAdminUser(String username) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        return new User(username, "notused", true, true, true, true, grantedAuthorities);
    }

    private UserDetails getRegularUser(String username) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        return new User(username, "notused", true, true, true, true, grantedAuthorities);
    }
}
