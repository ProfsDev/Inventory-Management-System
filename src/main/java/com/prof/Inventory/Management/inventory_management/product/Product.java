package com.prof.Inventory.Management.inventory_management.product;

import com.prof.Inventory.Management.inventory_management.available_quantity.Quantity;
import com.prof.Inventory.Management.inventory_management.brand.Brand;
import com.prof.Inventory.Management.inventory_management.category.Category;
import com.prof.Inventory.Management.inventory_management.package_info.PackageInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Name field is required")
    private String name;

    @ManyToOne
    private Brand brand;
    @ManyToOne
    @NotNull
    private Category category;
    @NotNull
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Quantity quantity;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private PackageInfo packageInfo;
    public Product() {
    }

    public Product(String name, Brand brand, Category category, Quantity quantity, PackageInfo packageInfo) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
        this.packageInfo = packageInfo;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantityList) {
        this.quantity = quantityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", category=" + category +
                ", quantityList=" + quantity +
                ", packageInfo=" + packageInfo +
                '}';
    }
}
