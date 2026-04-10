package com.example.transferapi.controller;

import com.example.transferapi.dto.TransferRequest;
import com.example.transferapi.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransferController {
    private final AccountService service;

    public TransferController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request) {
        service.transfer(
                request.fromAccountId,
                request.toAccountId,
                request.amount
        );
        return "Transfer successful";
    }

    @GetMapping("/accounts")
    public Object getAccounts() {
        return service.getAccounts();
    }
}
