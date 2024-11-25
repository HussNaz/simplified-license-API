package com.example.simplifiedLicenseService.repository;

import com.example.simplifiedLicenseService.model.SimplifiedLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimplifiedLicenseRepository extends JpaRepository<SimplifiedLicense, String> {
}
