package com.prof.Inventory.Management.inventory_management.product;

import com.prof.Inventory.Management.inventory_management.brand.Brand;
import com.prof.Inventory.Management.inventory_management.category.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO ToProductDTO(Product product) {

        return new ProductDTO(
                product.getName(),
                product.getBrand().getId(),
                product.getCategory().getId(),
                product.getQuantity(),
                product.getPackageInfo()
        );
    }

    public Product fromProductDTO(ProductDTO productDTO) {

        return new Product(
                productDTO.getName(),
                new Brand(productDTO.getBrandId()),
                new Category(productDTO.getCategoryId()),
                productDTO.getQuantity(),
                productDTO.getPackageInfo()
                );
    }
}
