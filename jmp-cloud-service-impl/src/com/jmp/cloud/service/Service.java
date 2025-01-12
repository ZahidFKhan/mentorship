package com.jmp.cloud.service;

import main.java.dtos.BankCard;
import main.java.dtos.Subscription;
import main.java.dtos.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Service {
    void subscribe(BankCard x);

   Subscription getSubscriptionByBankCardNumber(String x);

    List<User> getAllUsers();

    default double getAverageUserAge() {
        return getAllUsers()
                .stream()
                .mapToInt(x -> LocalDate.now()
                        .minusYears(x.birthday().getYear()).getYear()).average().getAsDouble();

    }


}
