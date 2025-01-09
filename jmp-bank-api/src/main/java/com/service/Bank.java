package main.java.com.service;

import main.java.dtos.BankCard;
import main.java.dtos.BankCardType;
import main.java.dtos.User;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
