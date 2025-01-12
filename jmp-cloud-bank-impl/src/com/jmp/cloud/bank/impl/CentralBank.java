package com.jmp.cloud.bank.impl;

import main.java.com.service.Bank;
import main.java.dtos.Subscription;
import main.java.dtos.User;

import java.util.List;
import java.util.function.Predicate;

public class CentralBank implements Bank {
    @Override
    public main.java.dtos.BankCard createBankCard(User user, main.java.dtos.BankCardType bankCardType) {
        return null;
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return null;
    }
}
