package com.rs.axondemo.cqrses.controller.ui;


import lombok.Value;

import java.math.BigDecimal;

@Value
public class AccountUIData{
    private final BigDecimal balance;
    private final String owner;


}
