package com.fhict.server.products;

import com.fhict.server.ISellable;
/*
    Why not abstract?
 */
public class Product implements ISellable {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("name: %s, price: %s", this.name, String.valueOf(this.price));
    }
}
