package dev.vaibhav.springrest.service;

import dev.vaibhav.springrest.entity.ApplicationUser;
import dev.vaibhav.springrest.vo.LoginResponseVO;
import dev.vaibhav.springrest.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    public void registerUser(UserVO user) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setUsername(user.getUsername());
        applicationUser.setPassword(encoder.encode(user.getPassword()));
        userService.save(applicationUser);
    }

    public LoginResponseVO login(UserVO user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            String jwt = tokenService.generateJWT(authentication);

            return new LoginResponseVO(userService.getUserByUsername(user.getUsername()), jwt);

        } catch (Exception e) {
            return new LoginResponseVO();
        }
    }
}
