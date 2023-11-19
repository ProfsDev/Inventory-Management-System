package com.prof.Inventory.Management.inventory_management.exception_handler;

public class OtherNotFoundException extends RuntimeException{

    public OtherNotFoundException(String message) {
        super(message);
    }

    public OtherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
