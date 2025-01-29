package com.jmp.cloud.service;

import com.jmp.cloud.exception.ProhibitedSubscription;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import jmp.dtos.BankCard;
import jmp.dtos.Subscription;
import jmp.dtos.User;

public class ServiceImpl implements Service {
  @Override
  public void subscribe(BankCard bankCard) {
    System.out.println(bankCard);
  }

  @Override
  public Subscription getSubscriptionByBankCardNumber(String bankCardNumber) {
    final var subscription = new Subscription(bankCardNumber, LocalDate.now());
    return Optional.of(subscription).orElseThrow(ProhibitedSubscription::new);
  }

  @Override
  public List<User> getAllUsers() {
    return List.of(
        new User("User1", "surname2", LocalDate.now()),
        new User("User2", "surname2", LocalDate.now()),
        new User("User3", "surname2", LocalDate.now()),
        new User("User4", "surname2", LocalDate.now()),
        new User("User5", "surname2", LocalDate.now()));
  }
}
