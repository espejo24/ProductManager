package ru.netology.domain.product;

public class Smartphone extends Product {

    // private String name;    от родителя
    private String producer;

    public Smartphone(int id, String name, int price, String producer) {   // all args + родитель
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
