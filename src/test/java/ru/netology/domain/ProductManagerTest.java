package ru.netology.domain;

import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product book1 = new Book(8, "Дневник Адама", 350, "Марк Твен");
    Product book2 = new Book(13, "Цветы для Элджернона", 450, "Дэниел Киз");
    Product book3 = new Book(17, "История мира в 10½ главах", 550, "Джулиан Барнс");

    Product smartphone1 = new Smartphone(7, "iPhone 13 Pro Max", 160_000, "APPLE");
    Product smartphone2 = new Smartphone(18, "Galaxy S22 Ultra", 150_000, "SAMSUNG");
    Product smartphone3 = new Smartphone(21, "P50 Pro", 115_000, "HUAWEI");

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void shouldSearchBy() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("а");
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);

        Product[] actual1 = manager.searchBy("r");
        Product[] expected1 = {smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void shouldOk() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.findAll();

        Product[] actual = manager.searchBy("Ok");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBySearchId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        manager.removeById(7);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);

        Product[] actual2 = manager.searchBy("r");
        Product[] expected2 = {smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldEmptyProducts() {
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneProduct() {
        manager.add(book1);

        manager.removeById(8);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTwoProducts() {
        manager.add(book1);
        manager.add(book2);

        manager.removeById(13);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);
    }
}