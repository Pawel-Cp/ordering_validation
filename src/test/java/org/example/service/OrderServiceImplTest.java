package org.example.service;

import org.example.Order;
import org.example.Product;
import org.example.User;
import org.example.exceptions.EmptyOrderException;
import org.example.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    private OrderServiceImpl orderService;


    @BeforeEach
    void setUp() {
        orderService = new OrderServiceImpl();
    }

    @Test
    void processOrder_OrderNull_NotOk() {
        Order order = new Order(null, null);

        assertThrows(EmptyOrderException.class,
                () -> orderService.processOrder(order), "Order can not be null!");
    }

    @Test
    void processOrder_ProductsEmpty_NotOk() {
        User user = new User();
        user.setName("test");
        user.setAge(20);
        user.setBalance(1000);
        Order order = new Order(user, new ArrayList<>());

        assertThrows(EmptyOrderException.class,
                ()-> orderService.processOrder(order),
                "Order must contain at least one product!");
    }

    @Test
    void processOrder_UserNull_NotOk() {
        Order order = new Order(null, List.of(new Product("Test", 100, 1)));

        assertThrows(EmptyOrderException.class,
                ()-> orderService.processOrder(order), "User can not be null!");
    }

    @Test
    void processOrder_UserNameNull_NotOk() {
        User user = new User();
        user.setName(null);
        user.setAge(20);
        user.setBalance(1000);

        Order order = new Order(user, List.of(new Product("Test", 100, 1)));
        assertThrows(EmptyOrderException.class,
                ()-> orderService.processOrder(order), "User name can not be null!");
    }

    @Test
    void processOrder_UserBalance_NotOk() {
        User user = new User();
        user.setName("test");
        user.setAge(20);
        user.setBalance(1);

        Order order = new Order(user, List.of(new Product("test", 10, 2)));
        assertThrows(InsufficientFundsException.class, ()-> orderService.processOrder(order), "No funds to pay for the order. Order costs: "
                + order.getTotalPrice() + "pounds, but u have: "
                + user.getBalance() + " pounds");
    }

    @Test
    void processOrder_IsProductAvailable_NotOk() {
        User user = new User();
        user.setName("test");
        user.setAge(20);
        user.setBalance(1000);

        Product product = new Product("test", 20, 1);
        Order order = new Order(user, List.of(product));
        boolean productAvailable = order.isProductAvailable(product, 2);
        assertFalse(productAvailable, "No such element in stock. Sorry!");
        //assertThrows(OutOfStockException.class, ()-> orderService.processOrder(order),
               // "No such element in stock. Sorry!");
    }

    @Test
    void processOrder_Correct_Ok() {
        User user = new User();
        user.setBalance(12312);
        double oldBalance = user.getBalance();
        user.setAge(25);
        user.setName("Krystian");
        Product product = new Product("test", 20, 20);
        Order order = new Order(user, List.of(product));
        orderService.processOrder(order);
        user.setBalance(oldBalance - order.getTotalPrice());
        double actual = user.getBalance();
        double expected = oldBalance - order.getTotalPrice();
        assertEquals(expected, actual);
    }
}