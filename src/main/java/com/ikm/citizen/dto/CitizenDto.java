package com.ikm.citizen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDto {
    private Integer citizenId;
    private String citizenName;
    private String citizenAddress;
    private String citizenPhone;
    private LocalDate citizenDob;
}

