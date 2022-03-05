package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.product.Book;
import ru.netology.domain.product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    @Test
    public void shouldAddBookUseRepo() {
        Book book = new Book(1, "Don Quixote", 500, "Marquez");
        ProductRepository repo = new ProductRepository();
        repo.save(book);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldAddSmartphoneUseRepo() {
        Smartphone phone = new Smartphone(1, "Samsung", 1000, "Russia");
        ProductRepository repo = new ProductRepository();
        repo.save(phone);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBookByIdUseRepo() {
        Book uno = new Book(1, "Uno", 100, "Marquez");
        Book dos = new Book(2, "Dos", 100, "Marquez");
        ProductRepository repo = new ProductRepository();
        repo.save(uno);
        repo.save(dos);
        repo.removeById(1);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldFindBookByIdUseRepo() {
        Book book = new Book(1, "Don Quixote", 500, "Marquez");
        ProductRepository repo = new ProductRepository();
        repo.save(book);
        repo.findById(1);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldFindBookByIdUseRepoFalse() {
        Book book = new Book(1, "Don Quixote", 500, "Marquez");
        ProductRepository repo = new ProductRepository();
        repo.save(book);
        repo.findById(2);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }
}