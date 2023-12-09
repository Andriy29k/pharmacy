package com.example.main.services;

import com.example.main.models.Medication;
import com.example.main.repositories.MedicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MedicationService {
    private final MedicationRepository medicationRepository;

    public List<Medication> medicationList(){
        return medicationRepository.findAll();
    }


    public Medication getMedicationById(Long id) {
        return medicationRepository.findById(id).orElse(null);
    }

    public void saveMedication(Medication medication) {
        log.info("Saving new {}", medication);
        medicationRepository.save(medication);
    }

    public void deleteMedication(Long id) {
        medicationRepository.deleteById(id);
    }

}
