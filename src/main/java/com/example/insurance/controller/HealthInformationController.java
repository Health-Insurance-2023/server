package com.example.insurance.controller;

import com.example.insurance.common.CustomSuccessResponse;
import com.example.insurance.entity.HealthInformation;
import com.example.insurance.service.HealthInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/health")
public class HealthInformationController {
    private final HealthInformationService healthInformationService;

    @Autowired
    public HealthInformationController(HealthInformationService healthInformationService) {
        this.healthInformationService = healthInformationService;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHealthInformation(@PathVariable Long id,@RequestBody HealthInformation healthInformation) {
        healthInformationService.updateHealthInformation(id,healthInformation);
        return ResponseEntity.status(HttpStatus.OK).body(new CustomSuccessResponse("Update Successful", "Success"));
    }
}
