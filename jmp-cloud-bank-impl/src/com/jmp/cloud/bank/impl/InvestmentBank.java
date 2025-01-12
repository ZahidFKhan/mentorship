package com.jmp.cloud.bank.impl;

import main.java.com.service.Bank;
import main.java.dtos.BankCard;
import main.java.dtos.BankCardType;
import main.java.dtos.Subscription;
import main.java.dtos.User;

import java.util.List;
import java.util.function.Predicate;

public class InvestmentBank implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return null;
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return null;
    }
}
