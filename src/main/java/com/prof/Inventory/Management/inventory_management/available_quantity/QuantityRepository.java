package com.prof.Inventory.Management.inventory_management.available_quantity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuantityRepository extends JpaRepository<Quantity, Long> {
}
