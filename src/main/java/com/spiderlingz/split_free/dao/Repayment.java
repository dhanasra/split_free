package com.spiderlingz.split_free.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repayment {
    private long from;
    private long to;
    private String amount;
}
