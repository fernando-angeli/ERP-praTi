package com.erp.maisPraTi.model;

import com.erp.maisPraTi.enums.ClientStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_clients")
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String gender;
    private String cpfOrCnpj;
    private String rgOrIe;
    private String phoneNumber;
    private String email;
    private String address;
    private String number;
    private String district;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private LocalDate birthDate;
    private BigDecimal creditLimit;
    private String notes;
    @Enumerated(EnumType.STRING)
    private ClientStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
