package dev.vaibhav.springrest.contoller;

import dev.vaibhav.springrest.service.AuthService;
import dev.vaibhav.springrest.vo.LoginResponseVO;
import dev.vaibhav.springrest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public UserVO registerUser(@RequestBody UserVO user) {
        authService.registerUser(user);
        return user;
    }

    @PostMapping("/login")
    public LoginResponseVO loginUser(@RequestBody UserVO user) {
        return authService.login(user);
    }
}
