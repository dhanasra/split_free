package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaData {
    private ErrorStatus cash;
    private ErrorStatus paypal;
    private ErrorStatus paytm;
    private ErrorStatus admin;
    private Feature feature;
    private List<SubscriptionPlan> offered_plan;
}
