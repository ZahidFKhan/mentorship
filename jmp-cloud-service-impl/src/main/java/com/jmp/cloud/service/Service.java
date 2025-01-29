package com.jmp.cloud.service;

import jmp.dtos.BankCard;
import jmp.dtos.Subscription;
import jmp.dtos.User;

import java.time.LocalDate;
import java.util.List;

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
