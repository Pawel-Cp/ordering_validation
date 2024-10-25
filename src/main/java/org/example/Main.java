package org.example;

import org.example.exceptions.EmptyOrderException;
import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.UnderageUserException;
import org.example.service.OrderService;
import org.example.service.OrderServiceImpl;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();
        User user = new User("Pioitr", 20, 2000);
        User user1 = new User("Pawel", 17, 10000);
        User user2 = new User(null, 27, 1000);
        User user3 = new User("Piotrek", 20, 5);

        Product product = new Product("test1", 20, 20);
        Order order = new Order(user2, List.of(product)); // Some order setup

        try {
            orderService.processOrder(order);
        } catch (EmptyOrderException e) {
            System.out.println("Caught EmptyOrderException: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InvalidOrderException: " + e.getMessage());
        } catch (UnderageUserException e) {
            System.out.println("Caught UnderAgeUserException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught other exception: " + e.getMessage());
        }
    }
}