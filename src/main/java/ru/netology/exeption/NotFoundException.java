package ru.netology.exeption;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}