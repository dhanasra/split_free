package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    private long id;
    private String first_name;
    private String last_name;
    private String picture;
    private String email;
    private String phone;
    private String registration_status;
    private String locale;
    private String country_code;
    private String date_format;
    private String default_currency;
    private long notifications_count;
    private long notifications_read;
    private String time_zone;
}
