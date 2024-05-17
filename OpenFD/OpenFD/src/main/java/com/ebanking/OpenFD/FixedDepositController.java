package com.ebanking.OpenFD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fixed-deposit")
public class FixedDepositController {

    @Autowired
    private FixedDepositService service;

    @PostMapping("/open")
    public ResponseEntity<String> openFixedDeposit(@RequestBody FixedDeposit fd) {
        try {
            service.openFixedDeposit(fd);
            return ResponseEntity.ok("Fixed Deposit opened successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error opening Fixed Deposit: " + e.getMessage());
        }
    }
}
