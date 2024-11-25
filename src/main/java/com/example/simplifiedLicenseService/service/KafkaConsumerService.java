package com.example.simplifiedLicenseService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final LicenseTypeService licenseTypeService;

    @KafkaListener(topics = "license-topic", groupId = "simplified-license-group")
    public void consumeMessage(String message) {
        String[] parts = message.split(",");
        if (parts.length != 3) {
            System.err.println("Invalid message format.");
            return;
        }
        System.out.println("Consumed message: " + message);
        licenseTypeService.saveLicenseType(parts[0], parts[1],
                Boolean.parseBoolean(parts[2]));
    }
}