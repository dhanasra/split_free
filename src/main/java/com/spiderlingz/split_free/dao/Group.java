package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private long id;
    private String name;
    private String type;
    private String created_at;
    private String updated_at;
    private String avatar;
    private List<Member> members;
    private String inviteCode;
}
