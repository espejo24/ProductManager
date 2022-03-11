package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    Book book = new Book(1, "Don Quixote", 500, "Cervantes");
    Smartphone phone = new Smartphone(1, "Samsung", 1000, "Russia");
    Book uno = new Book(1, "Uno", 100, "Marquez");
    Book dos = new Book(2, "Dos", 100, "Marquez");
    Book tres = new Book(3, "Tres", 100, "Marquez");

    @Test
    public void shouldAddBookUseRepo() {
        repo.save(book);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldAddSmartphoneUseRepo() {
        repo.save(phone);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveBookByIdUseRepo() {
        repo.save(uno);
        repo.save(dos);
        repo.save(tres);
        repo.removeById(1);
        int expected = 2;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldRemoveBookByIdUseRepo2() {     // проверяем, что удалили нужный нам товар,
        repo.save(uno);                             // с указанным id
        repo.save(dos);
        repo.save(tres);
        repo.removeById(3);
        Product[] actual = repo.findAll();
        Product[] expected = {uno, dos};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByIdUseRepo() {
        repo.save(uno);
        repo.save(dos);
        repo.save(tres);
        //repo.findById(3);
        //string expected = tres;
        //int actual = repo.findById(3);
        //assertEquals(expected, actual);
        Product actual = repo.findById(2);
        Product expected = dos;
        assertEquals(expected, actual);
    }


    @Test
    public void shouldFindBookByIdUseRepoFalse() {
        repo.save(book);
        repo.findById(2);
        int expected = 1;
        int actual = repo.findAll().length;
        assertEquals(expected, actual);

    }
}