package com.EmployeManagementSystem.springMock.Controller;

import com.EmployeManagementSystem.springMock.Model.User;
import com.EmployeManagementSystem.springMock.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {
       return userService.addUser(user);
    }
    @GetMapping("overallWinner")
    public User overAllwinner()throws Exception
    {
        return userService.overAllWinner();
    }
}
