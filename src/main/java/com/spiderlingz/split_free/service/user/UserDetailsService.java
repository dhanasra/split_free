package com.spiderlingz.split_free.service.user;

import com.spiderlingz.split_free.dao.Group;
import com.spiderlingz.split_free.dao.UserDetail;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserDetailsService {
    String createUser(UserDetail userDetail) throws ExecutionException, InterruptedException;

    String editUser(long userId, UserDetail userDetail) throws ExecutionException, InterruptedException;

    List<UserDetail> getAllUsers() throws ExecutionException, InterruptedException;

    UserDetail getUserById(long userId) throws ExecutionException, InterruptedException;

    String deleteUserDetails(long userId) throws ExecutionException, InterruptedException;
}
