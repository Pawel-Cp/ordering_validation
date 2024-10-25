package org.example.service;

import org.example.Order;
import org.example.Product;
import org.example.User;
import org.example.exceptions.EmptyOrderException;
import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.OutOfStockException;
import org.example.exceptions.UnderageUserException;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private static final int MIN_AGE = 18;

    @Override
    public void processOrder(Order order) {

        if (order == null) {
            throw new EmptyOrderException("Order can not be null!");
        }
        if (order.getUser() == null) {
            throw new EmptyOrderException("User can not be null!");
        }

        if (order.getUser().getName() == null) {
            throw new EmptyOrderException("User name can not be null!");
        }

        double totalCost = order.getTotalPrice();
        User user = order.getUser();
        if (user.getBalance() < totalCost) {
            throw new InsufficientFundsException("No funds to pay for the order. Order costs: "
                    + order.getTotalPrice() + "pounds, but u have: "
                    + user.getBalance() + " pounds");
        }
        if (order.getProducts().isEmpty()) {
            throw new EmptyOrderException("Oder must contain at least one product!");
        }
        if (user.getAge() <= MIN_AGE) {
            throw new UnderageUserException("Minumum age is 18. You have enter " + user.getAge());
        }

    }
}
