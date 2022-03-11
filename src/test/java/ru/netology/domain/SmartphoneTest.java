package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    @Test
    void shouldSetProducer() {
        Smartphone phone = new Smartphone(1, "Samsung", 1000, "Russia");
        phone.setProducer("Russia");
        String expected = "Russia";
        String actual = phone.getProducer();
        assertEquals(expected, actual);
    }
}

