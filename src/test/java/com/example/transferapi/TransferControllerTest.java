package com.example.transferapi;

import com.example.transferapi.dto.TransferRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransferControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testTransferSuccess() {
        TransferRequest req = new TransferRequest();
        req.fromAccountId = "A";
        req.toAccountId = "B";
        req.amount = 100;

        ResponseEntity<String> response =
                restTemplate.postForEntity("/api/transfer", req, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("successful"));
    }

    @Test
    void testInsufficientFunds() {
        TransferRequest req = new TransferRequest();
        req.fromAccountId = "A";
        req.toAccountId = "B";
        req.amount = 10000;

        ResponseEntity<String> response =
                restTemplate.postForEntity("/api/transfer", req, String.class);

        assertTrue(response.getBody().contains("Insufficient"));
    }
}
