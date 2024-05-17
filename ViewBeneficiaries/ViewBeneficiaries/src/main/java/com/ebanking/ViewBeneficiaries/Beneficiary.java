package com.ebanking.ViewBeneficiaries;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String beneficiaryAccountNo;

    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private String ifscCode;

    @Column(nullable = false)
    private String beneficiaryName;

    @Column(nullable = false)
    private String emailId;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long customerId;
}

