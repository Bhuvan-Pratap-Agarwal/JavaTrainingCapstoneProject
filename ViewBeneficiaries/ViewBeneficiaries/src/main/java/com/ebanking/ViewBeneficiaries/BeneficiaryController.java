package com.ebanking.ViewBeneficiaries;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @GetMapping("/beneficiaries")
    public List<Beneficiary> getBeneficiaries(@RequestParam Long customerId) {
        return beneficiaryService.getBeneficiariesByCustomerId(customerId);
    }
}

