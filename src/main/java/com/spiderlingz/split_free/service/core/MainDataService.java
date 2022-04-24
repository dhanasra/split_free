package com.spiderlingz.split_free.service.core;

import com.spiderlingz.split_free.dao.MainData;
import com.spiderlingz.split_free.dao.UserDetail;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface MainDataService {

    String createMainData(UserDetail userDetail) throws ExecutionException, InterruptedException;

    String editMainData(long userId, MainData mainData) throws ExecutionException, InterruptedException;

    List<MainData> getAllMainData() throws ExecutionException, InterruptedException;

    MainData getUserMainData(long userId) throws ExecutionException, InterruptedException;

    String deleteMainData(long userId) throws ExecutionException, InterruptedException;

}
