package com.spiderlingz.split_free.service.user.impl;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.spiderlingz.split_free.dao.UserDetail;
import com.spiderlingz.split_free.service.core.MainDataService;
import com.spiderlingz.split_free.service.user.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//CRUD operations
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String COL_NAME="user";

    @Autowired
    private MainDataService mainDataService;

    @Override
    public String createUser(UserDetail userDetail) throws ExecutionException, InterruptedException {
        List<UserDetail> users = getAllUsers();
        long lastUserId = users.size()!=0 ? users.get(users.size()-1).getId() : -1;
        userDetail.setId(lastUserId+1);
        String id = String.valueOf(userDetail.getId());
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(userDetail);
        mainDataService.createMainData(userDetail);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String editUser(long userId, UserDetail userDetail) throws ExecutionException, InterruptedException {
        String id = String.valueOf(userId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(userDetail);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public List<UserDetail> getAllUsers() throws ExecutionException, InterruptedException {
        List<UserDetail> users = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future  = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            users.add(document.toObject(UserDetail.class));
        }
        return users;
    }

    @Override
    public UserDetail getUserById(long userId) throws ExecutionException, InterruptedException {
        String id = String.valueOf(userId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> document  = dbFirestore.collection(COL_NAME).document(id).get();
        return document.get().toObject(UserDetail.class);
    }

    @Override
    public String deleteUserDetails(long userId) throws ExecutionException, InterruptedException {
        String id = String.valueOf(userId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).delete();
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
