package com.prof.Inventory.Management.inventory_management.available_quantity;

import com.prof.Inventory.Management.inventory_management.exception_handler.OtherNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityService {

    private final QuantityRepository quantityRepository;

    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public List<Quantity> findAllQuantities() {
        return quantityRepository.findAll();
    }

    public Quantity findQuantityById(Long quantityId) {
        if (!quantityRepository.existsById(quantityId)) {
            String errorMessage = String.format("Quantity with id '%s' does not exist", quantityId);
            throw new OtherNotFoundException(errorMessage);
        }
        return quantityRepository.findById(quantityId).get();
    }

    public Long addNewQuantity(Quantity quantity) {
        return quantityRepository.save(quantity).getId();
    }

    public Quantity updateQuantity(long quantityId, Quantity quantity) {
        if (!quantityRepository.existsById(quantityId)) {
            throw new OtherNotFoundException(String.format("Quantity with id '%s' does not exist", quantityId));
        }
        quantity.setId(quantityId);
        return quantityRepository.save(quantity);
    }

    public void deleteQuantityById(long quantityId) {
        if (!quantityRepository.existsById(quantityId)){
            throw new OtherNotFoundException(String.format("Quantity with id '%s' does not exist", quantityId));
        }

        quantityRepository.deleteById(quantityId);
    }
}
