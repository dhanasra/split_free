package com.spiderlingz.split_free.controller.user;

import com.spiderlingz.split_free.dao.UserDetail;
import com.spiderlingz.split_free.service.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/split_free/user")
public class UserDetailController {
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public String createUser(@RequestBody UserDetail userDetail) throws InterruptedException, ExecutionException {
        return userDetailsService.createUser(userDetail);
    }

    @GetMapping
    public List<UserDetail> getAllUsers() throws InterruptedException, ExecutionException {
        return userDetailsService.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDetail getUserById(
            @PathVariable(value = "id") long userId) throws InterruptedException, ExecutionException {
        return userDetailsService.getUserById(userId);
    }

    @PutMapping("{id}")
    public String editUser(
            @PathVariable(value = "id") long userId,
            @RequestBody UserDetail userDetail) throws InterruptedException, ExecutionException {
        return userDetailsService.editUser(userId,userDetail);
    }

    @DeleteMapping("{id}")
    public String deleteUser( @PathVariable(value = "id") long userId ) throws InterruptedException, ExecutionException {
        return userDetailsService.deleteUserDetails(userId);
    }
}