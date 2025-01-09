package main.java.dtos;

import java.time.LocalDate;

public record User(String name, String surname, LocalDate birthday) {
}