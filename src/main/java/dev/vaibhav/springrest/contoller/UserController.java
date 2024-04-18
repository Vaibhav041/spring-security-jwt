package dev.vaibhav.springrest.contoller;

import dev.vaibhav.springrest.entity.ApplicationUser;
import dev.vaibhav.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get-all-users")
    public List<ApplicationUser> getAllUsers() {
        return userService.getAllUsers();
    }
}
