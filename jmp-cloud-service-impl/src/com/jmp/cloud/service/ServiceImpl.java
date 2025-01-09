package com.jmp.cloud.service;

import main.java.dtos.BankCard;
import main.java.dtos.Subscription;
import main.java.dtos.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ServiceImpl implements Service {
    @Override
    public void subscribe(BankCard bankCard) {
        System.out.println(bankCard);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        return Optional.of(new Subscription(bankCardNumber, LocalDate.now()));
    }

    @Override
    public List<User> getAllUsers() {
        return List.of(new User("User1", "surname2", LocalDate.now()), new User("User2", "surname2", LocalDate.now()), new User("User3", "surname2", LocalDate.now()), new User("User4", "surname2", LocalDate.now()), new User("User5", "surname2", LocalDate.now())

        );
    }
}
