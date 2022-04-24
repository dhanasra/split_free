package com.spiderlingz.split_free.controller.group;

import com.spiderlingz.split_free.dao.Group;
import com.spiderlingz.split_free.service.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/split_free/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public String createGroup(@RequestBody Group group) throws InterruptedException, ExecutionException {
        return groupService.createGroup(group);
    }

    @GetMapping
    public List<Group> getAllGroups() throws InterruptedException, ExecutionException {
        return groupService.getAllGroup();
    }

    @GetMapping("/user/{id}")
    public List<Group> getUserGroups(
            @PathVariable(value = "id") long userId) throws InterruptedException, ExecutionException {
        return groupService.getUserGroup(userId);
    }

    @PutMapping("{id}")
    public String editGroup(
            @PathVariable(value = "id") long groupId,
            @RequestBody Group group) throws InterruptedException, ExecutionException {
        return groupService.editGroup(groupId,group);
    }

    @DeleteMapping("{id}")
    public String deleteGroup( @PathVariable(value = "id") long groupId ) throws InterruptedException, ExecutionException {
        return groupService.deleteGroup(groupId);
    }

}
