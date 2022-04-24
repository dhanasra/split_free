package com.spiderlingz.split_free.service.group;

import com.spiderlingz.split_free.dao.Expense;
import com.spiderlingz.split_free.dao.Group;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface GroupService {

    String createGroup(Group group) throws ExecutionException, InterruptedException;

    String editGroup(long groupId, Group group) throws ExecutionException, InterruptedException;

    List<Group> getAllGroup() throws ExecutionException, InterruptedException;

    List<Group> getUserGroup(long userId) throws ExecutionException, InterruptedException;

    String deleteGroup(long groupId) throws ExecutionException, InterruptedException;

}
