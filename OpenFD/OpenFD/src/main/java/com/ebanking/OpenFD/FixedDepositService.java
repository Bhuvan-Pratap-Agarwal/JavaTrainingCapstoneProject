package com.ebanking.OpenFD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FixedDepositService {
    @Autowired
    private FixedDepositRepository repository;

    public FixedDeposit openFixedDeposit(FixedDeposit fd) {
        return repository.save(fd);
    }
}

