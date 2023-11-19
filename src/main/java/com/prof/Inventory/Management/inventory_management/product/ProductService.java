package com.prof.Inventory.Management.inventory_management.product;

import com.prof.Inventory.Management.inventory_management.available_quantity.Quantity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<Product> findAllProducts() {
        List<Product> productList = productRepository.findAll(Sort.by("name"));
        if (productList.isEmpty()) {
            String errorMessage = "No product found";
            throw new ProductNotFoundException(errorMessage);
        }
        return productList;
    }

    public Optional<Product> findProductById(Long productId) {

        Optional<Product> foundProduct = productRepository.findById(productId);
        if (!foundProduct.isPresent()) {
            String errorMessage = "Product with id '%s' does not exist";
            throw new ProductNotFoundException(String.format(errorMessage, productId));
        }
        return foundProduct;
    }

    public ResponseEntity addNewProduct(ProductDTO productDTO) {
        Optional<Product> addedProduct = Optional.ofNullable(productRepository.save(productMapper.fromProductDTO(productDTO)));
        if (!addedProduct.isPresent()) {
            throw new ProductNotSavedException("An error occurred while saving the product");
        }


        return new ResponseEntity(addedProduct.get().getId(), HttpStatus.CREATED);
    }

    public ResponseEntity updateProduct(long productId, @Validated ProductDTO productDTO) {
        if (!productRepository.existsById(productId)) {
            String errorMessage = String.format("product with id '%s' does not exist", productId);
            throw new ProductNotFoundException(errorMessage);
        }

        Product product = productMapper.fromProductDTO(productDTO);
        product.setId(productId);
        if (product.getPackageInfo() == null) {
            product.setPackageInfo(productRepository.findById(product.getId()).get().getPackageInfo());
        }

        return ResponseEntity.ok(productRepository.save(product));
    }

    public void deleteStudentById(long productId) {

        if (!productRepository.existsById(productId)) {
            String errorMessage = String.format("Product with id '%s' does not exist");
            throw new ProductNotFoundException(errorMessage);
        }
        productRepository.deleteById(productId);
    }
}
