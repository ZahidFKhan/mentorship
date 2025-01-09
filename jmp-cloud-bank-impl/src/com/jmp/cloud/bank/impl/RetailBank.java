package com.jmp.cloud.bank.impl;

import main.java.com.service.Bank;
import main.java.dtos.BankCard;
import main.java.dtos.BankCardType;
import main.java.dtos.User;

public class RetailBank implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return null;
    }
}
