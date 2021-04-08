package com.davadzh.bluebeard.Controllers;

import com.davadzh.bluebeard.BLL.Core.Response;
import com.davadzh.bluebeard.BLL.Services.UserService.IUserService;
import com.davadzh.bluebeard.DAL.User.User;
import com.davadzh.bluebeard.DTO.UserDtos.UserGetTokenDto;
import com.davadzh.bluebeard.DTO.UserDtos.UserLoginDto;
import com.davadzh.bluebeard.DTO.UserDtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Response<User> register(@RequestBody UserRegisterDto userRegisterDto) {
        var newUser = userService.register(userRegisterDto);

        return new Response<>(newUser);
    }

    @PostMapping("/login")
    public Response<UserGetTokenDto> login(@RequestBody UserLoginDto userLoginDto) {
        var userGetTokenDto = userService.login(userLoginDto);

        return new Response<>(userGetTokenDto);
    }
}
