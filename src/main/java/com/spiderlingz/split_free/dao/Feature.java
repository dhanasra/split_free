package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    private FeatureStatus currency_conversion;
    private FeatureStatus search;
    private FeatureStatus charts;
    private FeatureStatus expense_charts;
    private FeatureStatus receipt_scanning;
    private FeatureStatus pro_setting_ad;
    private FeatureStatus invoice_generate;
}
