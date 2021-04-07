package com.davadzh.bluebeard.DAL.User;

import com.davadzh.bluebeard.BLL.DomainModels.UserStatusEnum;
import com.davadzh.bluebeard.DAL.BaseEntity;
import com.davadzh.bluebeard.DAL.Role.Role;
import com.davadzh.bluebeard.DTO.UserDtos.UserRegisterDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
public class User extends BaseEntity {
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatusEnum status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    public User() {}

    public User(UserRegisterDto userRegisterDto) {
        super();
        username = userRegisterDto.username;
        password = userRegisterDto.password;
    }

    public String getUsername() {
        return username;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
