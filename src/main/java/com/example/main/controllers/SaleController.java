package com.example.main.controllers;

import com.example.main.models.Sale;
import com.example.main.services.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @GetMapping("/sales")
    public List<Sale> sales() {
        return saleService.salesList();
    }

    @GetMapping("/sales/id/{id}")
    public Sale saleId(@PathVariable Long id){
        return saleService.getSaleById(id);
    }

    @PostMapping("/sales/add")
    public ResponseEntity<String> saveSale(@RequestBody Sale sale) {
        saleService.saveSale(sale);
        return ResponseEntity.ok("Sale added successfully");
    }

    @DeleteMapping("/sales/delete/{id}")
    public ResponseEntity<String> deleteSales(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.ok("Sale deleted successfully");
    }

}
