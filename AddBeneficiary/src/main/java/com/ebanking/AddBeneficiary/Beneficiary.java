package com.ebanking.AddBeneficiary;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long custId;
    private String beneficiaryAccountNo;
    private String accountType;
    private String ifscCode;
    private String beneficiaryName;
    private String email;
}

