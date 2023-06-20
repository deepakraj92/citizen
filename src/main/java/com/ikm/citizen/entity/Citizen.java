package com.ikm.citizen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "citizen", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citizen_id", length = 36, nullable = false)
    private Integer citizenId;

    @Column(name = "citizen_name", length = 50,nullable = false)
    private String citizenName;

    @Column(name = "citizen_address", nullable = false)
    private String citizenAddress;

    @Column(name = "citizen_phone", nullable = false)
    private String citizenPhone;

    @Column(name = "citizen_dob", nullable = false)
    private LocalDate citizenDob;
}
