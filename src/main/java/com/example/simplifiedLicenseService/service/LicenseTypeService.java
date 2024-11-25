package com.example.simplifiedLicenseService.service;

import com.example.simplifiedLicenseService.model.LicenseType;
import com.example.simplifiedLicenseService.repository.LicenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseTypeService {
    private final LicenseTypeRepository repository;

    public void saveLicenseType(String licenseTypeCode, String ministryCode, boolean canBeUsedPartially) {
        if (repository.findByLicenseTypeCode(licenseTypeCode).isPresent())
            throw new RuntimeException("License type already exists.");

        LicenseType licenseType = new LicenseType();
        licenseType.setLicenseTypeCode(licenseTypeCode);
        licenseType.setMinistryCode(ministryCode);
        licenseType.setCanBeUsedPartially(canBeUsedPartially);
        repository.save(licenseType);
    }

    public List<LicenseType> getAllLicenseTypes() {
        return repository.findAll();
    }

    public LicenseType getLicenseType(String licenseTypeCode) {
        return repository.findByLicenseTypeCode(licenseTypeCode).orElseThrow(() ->
                new IllegalArgumentException("License type not found."));
    }

}
