package com.erp.maisPraTi.dto;

import com.erp.maisPraTi.enums.ClientStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;
    @NotBlank(message = "O campo nome é obrigatório")
    private String fullName;
    private String gender;
    private String cpfOrCnpj;
    private String rgOrIe;
    private String phoneNumber;
    @Email(message = "E-mail inválido.", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "E-mail é obrigatório.")
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
