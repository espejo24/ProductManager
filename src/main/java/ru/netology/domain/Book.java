package ru.netology.domain;

public class Book extends Product {
    // private String name;    от родителя
    private String author;

    public Book(int id, String name, int price, String author) {     // all args + родитель
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }
}
