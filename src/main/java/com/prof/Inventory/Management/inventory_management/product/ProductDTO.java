package com.prof.Inventory.Management.inventory_management.product;

import com.prof.Inventory.Management.inventory_management.available_quantity.Quantity;
import com.prof.Inventory.Management.inventory_management.package_info.PackageInfo;
import jakarta.validation.constraints.*;

public class ProductDTO {

    @NotBlank(message = "name field is required")
    private String name;
    private long brandId;
    @Positive(message = "category id is required")
    private long categoryId;
    @NotNull(message = "Quantity is required")
    private Quantity quantity;
    private PackageInfo packageInfo;

    public ProductDTO() {
    }

    public ProductDTO(String name, long brandId, long categoryId, Quantity quantity, PackageInfo packageInfo) {
        this.name = name;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.packageInfo = packageInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public PackageInfo getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", quantityList=" + quantity +
                ", packageInfo=" + packageInfo +
                '}';
    }
}
