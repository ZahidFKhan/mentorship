package main.java.com.service;

import main.java.dtos.BankCard;
import main.java.dtos.BankCardType;
import main.java.dtos.Subscription;
import main.java.dtos.User;

import java.util.List;
import java.util.function.Predicate;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition);
}
