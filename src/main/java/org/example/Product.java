package org.example;

import javax.sound.sampled.Port;
import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private int quantityInStock;
    private int quantity;

    public Product(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantityInStock);
    }

    @Override
    public boolean equals(Object product) {

        if (product == this) {
            return true;
        }

        if ((product == null) || (product instanceof Product)) {
            return false;
        }

        Product convertedProduct = (Product) product;
        return Objects.equals(name, convertedProduct.name)
                && Objects.equals(price, convertedProduct.price)
                && Objects.equals(quantityInStock, convertedProduct.quantityInStock);
    }
}
