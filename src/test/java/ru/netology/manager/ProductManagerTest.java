package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book uno = new Book(1, "Domingo", 1000, "Tolstoy");
    Book dos = new Book(2, "Mumu", 1000, "Turgenev");
    Book tres = new Book(3, "Jugador", 2000, "Dostoevsky");
    Book cuatro = new Book(4, "Jugador", 2500, "Dostoevsky");
    Smartphone phone = new Smartphone(1, "Samsung", 1000, "Russia");

    @Test
    public void shouldAddOneBookUseRepoWithManager() {
        manager.add(uno);
        Product[] expected = {uno};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneSmartphoneUseRepoWithManager() {
        manager.add(phone);
        Product[] expected = {phone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookUseRepoWithManager() {
        manager.add(uno);
        manager.add(dos);
        Product[] actual = manager.searchBy("Mumu");
        Product[] expected = {dos};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookUseRepoWithManagerWhenNotFound() {
        manager.add(uno);   // проверили поиск, когда ни один товар не подходит под запрос
        manager.add(dos);
        Product[] actual = manager.searchBy("Jugador");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookUseRepoWithManagerWhenTwoBooksFound() {
        manager.add(uno);   // проверили поиск, когда два товара подходят под запрос
        manager.add(dos);
        manager.add(tres);
        manager.add(cuatro);
        Product[] actual = manager.searchBy("Jugador");
        Product[] expected = {tres, cuatro};
        assertArrayEquals(expected, actual);
    }

}