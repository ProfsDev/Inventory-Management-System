package com.prof.Inventory.Management.inventory_management.brand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Brand(String name) {
        this.name = name;
    }

    public Brand(long id) {
        this.id = id;
    }

    public Brand() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
