package com.jmp.bankapi;


import java.util.List;
import java.util.function.Predicate;

public interface Bank {
    main.java.dtos.BankCard createBankCard(main.java.dtos.User user, main.java.dtos.BankCardType bankCardType);

    List<main.java.dtos.Subscription> getAllSubscriptionsByCondition(Predicate<main.java.dtos.Subscription> condition);
}
