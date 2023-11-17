package com.prof.Inventory.Management.inventory_management.available_quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quantity")
public class QuantityController {
    private final QuantityService quantityService;

    @Autowired
    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @GetMapping("/{quantityId}")
    public ResponseEntity<Optional<Quantity>> findQuantityById(@PathVariable Long quantityId) {
        return new ResponseEntity(quantityService.findQuantityById(quantityId), HttpStatus.FOUND);
    }

    @PutMapping("/{quantityId}")
    public ResponseEntity updateQuantity(@PathVariable long quantityId, @RequestBody Quantity quantity) {
        return new ResponseEntity(quantityService.updateQuantity(quantityId, quantity), HttpStatus.OK);
    }

}
