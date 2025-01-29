package jmp.dtos;

import java.time.LocalDate;

public record Subscription(String bankcardNumber, LocalDate startDate) {}
