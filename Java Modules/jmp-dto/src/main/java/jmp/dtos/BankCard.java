package jmp.dtos;

public class BankCard {
    private final String number;
    private final User user;

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }
}