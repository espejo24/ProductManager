package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.product.Book;
import ru.netology.domain.product.Product;
import ru.netology.domain.product.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book uno = new Book(1, "Domingo", 1000, "Tolstoy");
    Book dos = new Book(1, "Mumu", 1000, "Turgenev");
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
}