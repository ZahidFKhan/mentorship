package com.jmp.cloud.bank.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import com.jmp.bankapi.Bank;
import jmp.dtos.BankCard;
import jmp.dtos.BankCardType;
import jmp.dtos.Subscription;
import jmp.dtos.User;

public class CentralBank implements Bank {
  @Override
  public BankCard createBankCard(
      User user, BankCardType bankCardType) {
    return null;
  }

  @Override
  public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
    System.out.println("Central Banking Subscriptions");
    return List.of(new Subscription("12", LocalDate.now()));
  }
}
