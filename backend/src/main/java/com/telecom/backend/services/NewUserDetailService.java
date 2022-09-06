package com.telecom.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.telecom.backend.beans.Users;
import com.telecom.backend.data.UserRepository;

@Component
public class NewUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         Users _user = repo.findByEmail(userName);
         
        if (_user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        
        // Have to sign in as Admin to Delete anything
        else if(_user.getUserName().equals("Chris")) {
            UserDetails user = User.withUsername(_user.getEmail()).password(_user.getPassword()).authorities("ADMIN").build();
            System.out.println(_user.getUserName() + " has attempted to login " + user.getAuthorities());
            return user;
        }
        else{
            UserDetails user = User.withUsername(_user.getEmail()).password(_user.getPassword()).authorities("USER").build();
            System.out.println(_user.getUserName() + " has attempted to login " + user.getAuthorities());
            return user;
        }
        
    }

    
    
}