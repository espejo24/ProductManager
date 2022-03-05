package ru.netology.domain.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void shouldSetId() {
        Product product = new Product(1, "Primero", 20);
        product.setId(1);
        int expected = 1;
        int actual = product.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetName() {
        Product product = new Product(2, "Segundo", 30);
        product.setName("Segundo");
        String expected = "Segundo";
        String actual = product.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrice() {
        Product product = new Product(3, "Trecero", 40);
        product.setPrice(40);
        int expected = 40;
        int actual = product.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldUseNoArgsConstructor() {
        Product product = new Product();
        assertEquals(0, product.getId());
    }
}