package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private long id;
    private String first_name;
    private String last_name;
    private String picture;
    private String email;
    private String registration_status;
    private List<Balance> balance;
    private List<Repayment> depts;
}
