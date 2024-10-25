package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private List<Product> products;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        List<Product> productList = new ArrayList<>(products);
        double result = 0;
        for (Product a : productList) {
            result += a.getPrice();
        }
        return result;
    }

    public boolean isProductAvailable(Product product, int quantity) {

        if (products.contains(product) && product.getQuantityInStock() > quantity) {
            return true;
        }
        return false;
    }
}
