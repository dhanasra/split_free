package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainData {
    private UserDetail user;
    private List<Group> groups;
    private List<Member> friends;
    private List<Notification> notifications;
    private MetaData meta_data;
}
