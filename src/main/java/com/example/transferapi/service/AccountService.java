package com.example.transferapi.service;

import com.example.transferapi.model.Account;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AccountService {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    public AccountService() {
        // Seed data
        accounts.put("A", new Account("A", 1000));
        accounts.put("B", new Account("B", 1000));
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void transfer(String fromId, String toId, double amount) {
        if (amount <= 0) throw new RuntimeException("Invalid amount");
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);
        if (from == null || to == null) {
            throw new RuntimeException("Account not found");
        }
        from.debit(amount);
        to.credit(amount);
    }
}
