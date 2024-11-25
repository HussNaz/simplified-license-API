package com.example.simplifiedLicenseService.service;

import com.example.simplifiedLicenseService.model.SimplifiedLicense;
import com.example.simplifiedLicenseService.repository.SimplifiedLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimplifiedLicenseService {
    private final SimplifiedLicenseRepository repository;

    public SimplifiedLicense create(SimplifiedLicense license) {
        license.setActive(true);
        license.setRemainingPackages(license.getPackagesAllowed());
        return repository.save(license);
    }

    public void useLicense(String licenseCode, int packages) {
        SimplifiedLicense license =
                repository.findById(licenseCode).orElseThrow(() -> new
                        IllegalArgumentException("License not found."));

        if (!license.isActive() || packages > license.getPackagesAllowed())
            throw new IllegalStateException("Invalid license usage.");

        license.setRemainingPackages(license.getRemainingPackages() - packages);
        repository.save(license);
    }

   public ResponseEntity<?> deactivateSimplifiedLicense(String licenseCode) {
        SimplifiedLicense license =
                repository.findById(licenseCode).orElseThrow(() -> new
                        IllegalArgumentException("License not found."));
        license.setActive(false);
        repository.save(license);
        return ResponseEntity.ok().body(license);
    }
}