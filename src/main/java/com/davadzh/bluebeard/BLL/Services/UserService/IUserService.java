package com.davadzh.bluebeard.BLL.Services.UserService;

import com.davadzh.bluebeard.DAL.User.User;
import com.davadzh.bluebeard.DTO.UserDtos.UserGetTokenDto;
import com.davadzh.bluebeard.DTO.UserDtos.UserLoginDto;
import com.davadzh.bluebeard.DTO.UserDtos.UserRegisterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    User register(UserRegisterDto userRegisterDto);
    UserGetTokenDto login(UserLoginDto userLoginDto);
    List<User> getAll();
    User findByUsername(String username);
    User findById(Long id);
    void delete(Long id);
}
