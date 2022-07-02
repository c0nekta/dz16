package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String title, int cost, String author) {
        super(id, title, cost);
        this.author = author;
    }
}