package com.fhict.server;

import com.fhict.server.products.Product;

public interface ISellable {
    String getName();
    void setName(String name);
    double getPrice();
    void setPrice(double price);
}
