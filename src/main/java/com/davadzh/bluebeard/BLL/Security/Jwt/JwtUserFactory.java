package com.davadzh.bluebeard.BLL.Security.Jwt;

import com.davadzh.bluebeard.BLL.DomainModels.UserStatusEnum;
import com.davadzh.bluebeard.DAL.Role.Role;
import com.davadzh.bluebeard.DAL.User.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                user.getStatus().equals(UserStatusEnum.ACTIVE)
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
