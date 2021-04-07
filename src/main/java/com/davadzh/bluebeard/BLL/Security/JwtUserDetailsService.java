package com.davadzh.bluebeard.BLL.Security;

import com.davadzh.bluebeard.BLL.Security.Jwt.JwtUser;
import com.davadzh.bluebeard.BLL.Security.Jwt.JwtUserFactory;
import com.davadzh.bluebeard.BLL.Services.UserService.IUserService;
import com.davadzh.bluebeard.DAL.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final IUserService userService;

    @Autowired
    public JwtUserDetailsService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        return jwtUser;
    }
}
