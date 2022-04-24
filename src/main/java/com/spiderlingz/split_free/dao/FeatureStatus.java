package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureStatus {
    private Boolean visible;
    private Boolean enabled;
    private Map<String,String> behaviour;
}
