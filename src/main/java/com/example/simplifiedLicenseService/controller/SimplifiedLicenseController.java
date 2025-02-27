package com.example.simplifiedLicenseService.controller;

import com.example.simplifiedLicenseService.model.SimplifiedLicense;
import com.example.simplifiedLicenseService.service.SimplifiedLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simplifiedLicense")
public class SimplifiedLicenseController {
    @Autowired
    private SimplifiedLicenseService simplifiedLicenseService;

    @PostMapping("/createLicense")
    public SimplifiedLicense createLicense(@RequestBody SimplifiedLicense license) {
        return simplifiedLicenseService.create(license);
    }

    @PutMapping("/useLicense")
    public void useLicense(@RequestParam String licenseCode,@RequestParam int packages) {
        simplifiedLicenseService.useLicense(licenseCode, packages);
    }

    @PutMapping("/deactivateLicense")
    public ResponseEntity<?> deactivateLicense(@RequestParam String licenseCode) {
       return ResponseEntity.ok().body(simplifiedLicenseService.deactivateSimplifiedLicense(licenseCode));
    }
}
