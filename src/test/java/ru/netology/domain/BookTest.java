package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void shouldSetAuthor() {
        Book book = new Book(1, "Domingo", 100, "Tolstoy");
        book.setAuthor("Tolstoy");
        String expected = "Tolstoy";
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }

}