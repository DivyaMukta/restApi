package com.example.transferapi.model;

public class Account {
    private final String id;
    private double balance;

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void debit(double amount) {
        if (balance < amount) throw new RuntimeException("Insufficient funds");
        balance -= amount;
    }

    public synchronized void credit(double amount) {
        balance += amount;
    }
}
