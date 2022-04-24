package com.spiderlingz.split_free.service.core.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.spiderlingz.split_free.dao.*;
import com.spiderlingz.split_free.service.core.MainDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class MainDataServiceImpl implements MainDataService {

    public static final String COL_NAME="core";

    @Override
    public String createMainData(UserDetail userDetail) throws ExecutionException, InterruptedException {
        MainData mainData = new MainData();
        String id = String.valueOf(userDetail.getId());
        mainData.setUser(userDetail);

        MetaData metaData = new MetaData();
        metaData.setCash(getErrorStatus("removed","",""));
        metaData.setPaypal(getErrorStatus("removed","",""));
        metaData.setPaytm(getErrorStatus("removed","",""));
        metaData.setAdmin(getErrorStatus("removed","",""));

        Feature feature = new Feature();
        feature.setCurrency_conversion(getFeatureStatus(true,true, getBehaviour("webview","url")));
        feature.setCharts(getFeatureStatus(true,true, getBehaviour("webview","url")));
        feature.setInvoice_generate(getFeatureStatus(true,true, getBehaviour("webview","url")));
        feature.setExpense_charts(getFeatureStatus(true,true, getBehaviour("webview","url")));
        feature.setSearch(getFeatureStatus(true,true, getBehaviour("webview","url")));
        feature.setReceipt_scanning(getFeatureStatus(true,true, getBehaviour("webview","url")));
        feature.setPro_setting_ad(getFeatureStatus(true,true, getBehaviour("webview","url")));
        metaData.setFeature(feature);

        List<SubscriptionPlan> subscriptionPlans = new ArrayList<>();
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        subscriptionPlan.setAmount("25.0");
        subscriptionPlan.setSubscription_id("101");
        subscriptionPlan.setPlatform("razorpay");
        subscriptionPlan.setInterval("month");
        subscriptionPlan.setCurrency_code("INR");
        subscriptionPlan.setTrial_period_days(7);
        subscriptionPlans.add(subscriptionPlan);
        metaData.setOffered_plan(subscriptionPlans);

        mainData.setMeta_data(metaData);

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(mainData);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    private ErrorStatus getErrorStatus(String status, String message, String url){
        ErrorStatus errorStatus = new ErrorStatus();
        errorStatus.setStatus(status);
        errorStatus.setMessage(message);
        errorStatus.setUrl(url);
        return errorStatus;
    }

    private FeatureStatus getFeatureStatus(Boolean visible, Boolean enabled, Map<String,String> behaviour){
        FeatureStatus featureStatus = new FeatureStatus();
        featureStatus.setVisible(visible);
        featureStatus.setEnabled(enabled);
        featureStatus.setBehaviour(behaviour);
        return featureStatus;
    }

    private Map<String, String> getBehaviour(String key, String value){
        Map<String,String> behaviour = new HashMap<>();
        behaviour.put(key, value);
        return behaviour;
    }

    @Override
    public String editMainData(long userId, MainData mainData) throws ExecutionException, InterruptedException {
        String id = String.valueOf(userId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).set(mainData);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public List<MainData> getAllMainData() throws ExecutionException, InterruptedException {
        List<MainData> mainDataList = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future  = dbFirestore.collection(COL_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (DocumentSnapshot document : documents) {
            mainDataList.add(document.toObject(MainData.class));
        }
        return mainDataList;
    }

    @Override
    public MainData getUserMainData(long userId) throws ExecutionException, InterruptedException {
        String id = String.valueOf(userId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> document  = dbFirestore.collection(COL_NAME).document(id).get();
        return document.get().toObject(MainData.class);
    }

    @Override
    public String deleteMainData(long userId) throws ExecutionException, InterruptedException {
        String id = String.valueOf(userId);
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(id).delete();
        return collectionsApiFuture.get().getUpdateTime().toString();
    }
}
