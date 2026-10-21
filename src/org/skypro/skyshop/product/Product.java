package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;

    public Product(String title, int price) {
        this.name = title;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }
}