package com.jmp.bankapi;


import jmp.dtos.BankCard;
import jmp.dtos.BankCardType;
import jmp.dtos.Subscription;
import jmp.dtos.User;

import java.util.List;
import java.util.function.Predicate;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition);
}
