package com.spiderlingz.split_free.service.group.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.spiderlingz.split_free.dao.Group;
import com.spiderlingz.split_free.dao.Member;
import com.spiderlingz.split_free.service.group.GroupService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class GroupServiceImpl implements GroupService {

    public static final String COL_NAME="group";

    @Override
    public String createGroup(Group group) throws ExecutionException, InterruptedException {
        List<Group> groups = getAllGroup();
        long lastGroupId = groups.size()!=0 ? groups.get(groups.size()-1).getId() : -1;
        group.setId(lastGroupId+1);
        String id = String.valueOf(group.getId());
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(group);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String editGroup(long groupId, Group group) throws ExecutionException, InterruptedException {
        String id = String.valueOf(groupId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(group);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public List<Group> getAllGroup() throws ExecutionException, InterruptedException {
        List<Group> groups = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future  = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            groups.add(document.toObject(Group.class));
        }
        return groups;
    }

    @Override
    public List<Group> getUserGroup(long userId) throws ExecutionException, InterruptedException {
        List<Group> groups = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future  = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            Group group = document.toObject(Group.class);
            if(group!=null){
                List<Member> members = group.getMembers();
                for(Member member : members){
                    if(member.getId()==userId){
                        groups.add(group);
                    }
                }
            }
        }
        return groups;
    }

    @Override
    public String deleteGroup(long groupId) throws ExecutionException, InterruptedException {
        String id = String.valueOf(groupId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).delete();
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
