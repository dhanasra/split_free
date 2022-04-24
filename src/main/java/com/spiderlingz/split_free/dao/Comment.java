package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private long id;
    private String content;
    private String comment_type;
    private String relation_type;
    private long relation_id;
    private String created_at;
    private String deleted_at;
    private User user;
}
