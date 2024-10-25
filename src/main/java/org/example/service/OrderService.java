package org.example.service;

import org.example.Order;
import org.example.exceptions.EmptyOrderException;
import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.OutOfStockException;
import org.example.exceptions.UnderageUserException;

public interface OrderService {

    void processOrder(Order order) throws EmptyOrderException,
            InsufficientFundsException,
            OutOfStockException,
            UnderageUserException;
}