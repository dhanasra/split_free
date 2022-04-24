package com.spiderlingz.split_free.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlan {
    private String amount;
    private String currency_code;
    private long trial_period_days;
    private String subscription_id;
    private String platform;
    private String interval;

}
