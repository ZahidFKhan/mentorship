package com.jmp.service.api;

import java.util.List;
import java.util.ServiceLoader;
import main.java.com.service.Bank;

public class Main {
  public static void main(String[] args) {
    var bank = ServiceLoader.load(Bank.class).findFirst().orElseThrow();
    final List<main.java.dtos.Subscription> allSubscriptionsByCondition =
        bank.getAllSubscriptionsByCondition(x -> !x.bankcardNumber().equals("123"));
    System.out.println(allSubscriptionsByCondition);
  }
}
