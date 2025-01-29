package com.jmp.cloud.bank.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import com.jmp.bankapi.Bank;
import main.java.dtos.BankCard;
import main.java.dtos.BankCardType;
import main.java.dtos.Subscription;
import main.java.dtos.User;

public class RetailBank implements Bank {
  @Override
  public BankCard createBankCard(User user, BankCardType bankCardType) {
    return null;
  }

  @Override
  public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
    System.out.println("RetailBank Bank Subscriptions");
    return List.of(new Subscription("Retail bank", LocalDate.now()));
  }
}
