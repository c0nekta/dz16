package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exeption.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(8, "Дневник Адама", 350, "Марк Твен");
    Product book2 = new Book(13, "Цветы для Элджернона", 450, "Дэниел Киз");
    Product book3 = new Book(17, "История мира в 10½ главах", 550, "Джулиан Барнс");

    Product smartphone1 = new Smartphone(7, "iPhone 13 Pro Max", 160_000, "APPLE");
    Product smartphone2 = new Smartphone(18, "Galaxy S22 Ultra", 150_000, "SAMSUNG");
    Product smartphone3 = new Smartphone(21, "P50 Pro", 115_000, "HUAWEI");

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(7);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProducts() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonexistentId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(50);
        });
    }
}
