package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private long id;
    private String type;
    private String created_at;
    private String created_by;
    private Map<String,String> source;
    private String image_url;
    private String image_shape;
    private String content;
}
