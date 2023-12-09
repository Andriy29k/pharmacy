package com.example.main.controllers;

import com.example.main.models.Medication;
import com.example.main.services.PharmacistService;
import com.example.main.models.Pharmacist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PharmacistController {
    private final PharmacistService pharmacistService;

    @GetMapping("/pharmacists")
    public List<Pharmacist> pharmacists() {
        return pharmacistService.pharmacistsList();
    }

    @GetMapping("/pharmacists/id/{id}")
    public Pharmacist pharmacistId(@PathVariable Long id){
        return pharmacistService.getProductById(id);
    }

    @PostMapping("/pharmacists/add")
    public ResponseEntity<String> addPharmacist(@RequestBody Pharmacist pharmacist) {
        pharmacistService.savePharmacist(pharmacist);
        return ResponseEntity.ok("Pharmacist added successfully");
    }

    @DeleteMapping("/pharmacists/delete/{id}")
    public ResponseEntity<String> deletePharmacist(@PathVariable Long id) {
        pharmacistService.deletePharmacist(id);
        return ResponseEntity.ok("Pharmacist deleted successfully");
    }
}
