package com.example.simplifiedLicenseService.controller;

import com.example.simplifiedLicenseService.model.LicenseType;
import com.example.simplifiedLicenseService.service.LicenseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenseType")
@RequiredArgsConstructor
public class LicenseTypeController {
    private final LicenseTypeService licenseTypeService;

    @PostMapping("/createLicenseType")
    public void saveLicenseType(@RequestBody LicenseType licenseType) {
        licenseTypeService.saveLicenseType(licenseType.getLicenseTypeCode(), licenseType.getMinistryCode(), licenseType.getCanBeUsedPartially());
    }

    @GetMapping("/getLicenseType")
    public LicenseType getLicenseType(@RequestParam String licenseTypeCode) {
        return licenseTypeService.getLicenseType(licenseTypeCode);
    }

    @GetMapping("/getAllLicenseTypes")
    public List<LicenseType> getAllLicenseTypes() {
        return licenseTypeService.getAllLicenseTypes();
    }
}
