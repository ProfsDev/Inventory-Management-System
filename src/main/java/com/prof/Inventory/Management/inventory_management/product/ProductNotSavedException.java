package com.prof.Inventory.Management.inventory_management.product;

public class ProductNotSavedException extends RuntimeException{

    public ProductNotSavedException(String message) {
        super(message);
    }
}
