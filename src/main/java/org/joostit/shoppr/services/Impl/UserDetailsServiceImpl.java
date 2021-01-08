package org.joostit.shoppr.services.Impl;

import org.joostit.shoppr.models.User;
import org.joostit.shoppr.repos.UserRepository;
import org.joostit.shoppr.services.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

    public void addUser(String userName, String password, String role){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);

        User user = new User();
        user.setUsername(userName);
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setRole(role);

        userRepository.save(user);
    }

}