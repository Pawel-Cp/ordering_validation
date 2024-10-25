package org.example;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private double balance;

    public User() {
    }

    public User(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, balance);
    }

    @Override
    public boolean equals(Object user) {

        if (user == this) {
            return true;
        }

        if ((user == null) || (!(user instanceof User))) {
            return false;
        }
        User convertedUser = (User) user;
        return Objects.equals(name, convertedUser.name)
                && Objects.equals(age, convertedUser.age)
                && Objects.equals(balance, convertedUser.balance);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
