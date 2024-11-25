package com.example.simplifiedLicenseService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class LicenseType {
    @Id
    private String licenseTypeCode;
    private String ministryCode;
    private boolean canBeUsedPartially;

    public boolean getCanBeUsedPartially() {
        return false;
    }
}
