package com.example.main.controllers;

import com.example.main.services.MedicationService;
import com.example.main.models.Medication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MedicationController {
    private final MedicationService medicationService;

    @GetMapping("/medications")
    public List<Medication> medications() {
        return medicationService.medicationList();
    }

    @GetMapping("/medications/{id}")
    public Medication getMedicationById(@PathVariable Long id) {
        return medicationService.getMedicationById(id);
    }

    @PostMapping("/medications/add")
    public ResponseEntity<String> addMedication(@RequestBody Medication medication) {
        medicationService.saveMedication(medication);
        return ResponseEntity.ok("Medication added successfully");
    }

    @DeleteMapping("/medications/delete/{id}")
    public ResponseEntity<String> deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return ResponseEntity.ok("Medication deleted successfully");
    }

}
