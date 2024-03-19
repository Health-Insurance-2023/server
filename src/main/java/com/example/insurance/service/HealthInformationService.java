package com.example.insurance.service;

import com.example.insurance.entity.HealthInformation;
import com.example.insurance.repository.HealthInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthInformationService {
    private final HealthInformationRepository healthInformationRepository;

    @Autowired
    public HealthInformationService(HealthInformationRepository healthInformationRepository) {
        this.healthInformationRepository = healthInformationRepository;
    }

    public HealthInformation getHealthInformationById(Long id) {
        return healthInformationRepository.findById(id).orElse(null);
    }

    public HealthInformation createHealthInformation(HealthInformation healthInformation) {
        return healthInformationRepository.save(healthInformation);
    }

    public void updateHealthInformation(Long id, HealthInformation newHealthInformation) {
        HealthInformation healthInformation = healthInformationRepository.findById(id).orElse(null);
        if(healthInformation != null)
        {
            healthInformation.setInjured(newHealthInformation.getInjured());
            healthInformation.setMedicalTreatment(newHealthInformation.getMedicalTreatment());
            healthInformation.setRadiationTreatment(newHealthInformation.getRadiationTreatment());
            healthInformation.setNeurologicalTreatment(newHealthInformation.getNeurologicalTreatment());
            healthInformation.setCardiovascularTreatment(newHealthInformation.getCardiovascularTreatment());
            healthInformation.setMetabolicTreatment(newHealthInformation.getMetabolicTreatment());
            healthInformation.setInfectiousDiseaseTreatment(newHealthInformation.getInfectiousDiseaseTreatment());
            healthInformation.setDisability(newHealthInformation.getDisability());
            healthInformation.setStrokeOrAsthma(newHealthInformation.getStrokeOrAsthma());
            healthInformation.setPregnant(newHealthInformation.getPregnant());
            healthInformation.setComplicationHistory(newHealthInformation.getComplicationHistory());
            healthInformationRepository.save(healthInformation);
        }

    }
}
