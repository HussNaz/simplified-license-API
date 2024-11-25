package com.example.simplifiedLicenseService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class SimplifiedLicense {
    @Id
    private String licenseCode;
    private String name;
    private String binNumber;
    private int packagesAllowed;
    private LocalDate expirationDate;
    private int remainingPackages;
    private boolean active;
}
