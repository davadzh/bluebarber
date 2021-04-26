package com.davadzh.bluebeard.BLL.Services.UserService;

import com.davadzh.bluebeard.BLL.Constants.ExceptionMessages;
import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.DomainModels.UserStatusEnum;
import com.davadzh.bluebeard.BLL.Exceptions.BadRequestException;
import com.davadzh.bluebeard.BLL.Security.Jwt.JwtTokenProvider;
import com.davadzh.bluebeard.DAL.Role.Role;
import com.davadzh.bluebeard.DAL.Role.RoleRepository;
import com.davadzh.bluebeard.DAL.User.User;
import com.davadzh.bluebeard.DAL.User.UserRepository;
import com.davadzh.bluebeard.DTO.UserDtos.UserGetTokenDto;
import com.davadzh.bluebeard.DTO.UserDtos.UserLoginDto;
import com.davadzh.bluebeard.DTO.UserDtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public void SetUserServiceConfig(UserRepository userRepository,
                                     RoleRepository roleRepository,
                                     BCryptPasswordEncoder passwordEncoder,
                                     AuthenticationManager authenticationManager,
                                     JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register(UserRegisterDto userRegisterDto) {
        Role roleUser = roleRepository.findByName("ADMIN");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        var newUser = new User(userRegisterDto);

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setRoles(userRoles);
        newUser.setStatus(UserStatusEnum.ACTIVE);

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public UserGetTokenDto login(UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    userLoginDto.username,
                    userLoginDto.password
            ));

            User user = findByUsername(userLoginDto.username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + userLoginDto.username + " not found");
            }

            String token = jwtTokenProvider.createToken(userLoginDto.username, user.getRoles());

            var userGetTokenDto = new UserGetTokenDto();
            userGetTokenDto.username = userLoginDto.username;
            userGetTokenDto.token = token;

            return userGetTokenDto;
        } catch (AuthenticationException e) {
            throw new BadRequestException(ExceptionMessages.INVALID_USERNAME_OR_PASSWORD);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
