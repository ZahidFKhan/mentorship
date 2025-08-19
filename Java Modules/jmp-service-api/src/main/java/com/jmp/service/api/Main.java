package com.jmp.service.api;

import com.jmp.bankapi.Bank;
import jmp.dtos.Subscription;

import java.util.List;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        var bank = ServiceLoader.load(Bank.class).findFirst().orElseThrow();
        final List<Subscription> allSubscriptionsByCondition =
                bank.getAllSubscriptionsByCondition(x -> !x.bankcardNumber().equals("123"));
        System.out.println(allSubscriptionsByCondition);

    }
    sealed interface X permits jmp_bank_api_module{

    }
}
