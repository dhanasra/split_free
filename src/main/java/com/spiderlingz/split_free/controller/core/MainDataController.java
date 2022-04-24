package com.spiderlingz.split_free.controller.core;

import com.spiderlingz.split_free.dao.MainData;
import com.spiderlingz.split_free.dao.UserDetail;
import com.spiderlingz.split_free.service.core.MainDataService;
import com.spiderlingz.split_free.service.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/split_free/core")
public class MainDataController {
    @Autowired
    private MainDataService mainDataService;

    @PostMapping
    public String createMainData(@RequestBody UserDetail userDetail) throws InterruptedException, ExecutionException {
        return mainDataService.createMainData(userDetail);
    }

    @GetMapping
    public List<MainData> getAllMainData() throws InterruptedException, ExecutionException {
        return mainDataService.getAllMainData();
    }

    @GetMapping("{id}")
    public MainData getUserMainData(
            @PathVariable(value = "id") long userId) throws InterruptedException, ExecutionException {
        return mainDataService.getUserMainData(userId);
    }

    @PutMapping("{id}")
    public String editMainData(
            @PathVariable(value = "id") long userId,
            @RequestBody MainData mainData) throws InterruptedException, ExecutionException {
        return mainDataService.editMainData(userId,mainData);
    }

    @DeleteMapping("{id}")
    public String deleteMainData( @PathVariable(value = "id") long userId ) throws InterruptedException, ExecutionException {
        return mainDataService.deleteMainData(userId);
    }
}
