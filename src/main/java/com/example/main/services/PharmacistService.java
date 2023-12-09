package com.example.main.services;

import com.example.main.models.Pharmacist;
import com.example.main.repositories.PharmacistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacistService {
    private final PharmacistRepository pharmacistRepository;
    public List<Pharmacist> pharmacistsList() {
        return pharmacistRepository.findAll();
    }

    public void savePharmacist(Pharmacist pharmacist){
        log.info("Saving new {}", pharmacist);
        pharmacistRepository.save(pharmacist);
    }

    public void deletePharmacist(Long id){
        pharmacistRepository.deleteById(id);
    }
    public Pharmacist getProductById(Long id){
        return pharmacistRepository.findById(id).orElse(null);
    }

}
