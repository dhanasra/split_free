package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserShare {
    private User user;
    private long user_id;
    private String paid_share;
    private String owed_share;
    private String net_balance;
}
