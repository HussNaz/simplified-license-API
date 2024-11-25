package com.example.simplifiedLicenseService.repository;

import com.example.simplifiedLicenseService.model.LicenseType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LicenseTypeRepository extends JpaRepository<LicenseType, String> {

    Optional<LicenseType> findByLicenseTypeCode(String licenseTypeCode);
}
