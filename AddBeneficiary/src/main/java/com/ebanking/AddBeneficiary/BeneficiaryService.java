package com.ebanking.AddBeneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryService {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    public void addBeneficiary(Beneficiary beneficiary) {
        // Save the beneficiary to the database
        beneficiaryRepository.save(beneficiary);
    }
}

