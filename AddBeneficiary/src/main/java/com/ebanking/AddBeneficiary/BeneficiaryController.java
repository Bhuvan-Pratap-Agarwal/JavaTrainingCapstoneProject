package com.ebanking.AddBeneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeneficiaryController 
{
    @Autowired
    private BeneficiaryService beneficiaryService;

    @PostMapping("/beneficiary")
    public String addBeneficiary(@RequestBody Beneficiary beneficiary) {
        beneficiaryService.addBeneficiary(beneficiary);
        return "Beneficiary added successfully. It will be active after 12 hours.";
    }
}

