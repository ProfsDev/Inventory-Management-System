package com.prof.Inventory.Management.inventory_management.product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity findProductById(@PathVariable Long productId){
        return new ResponseEntity(productService.findProductById(productId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity addNewProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.addNewProduct(productDTO);
    }

    @PutMapping("/{productId}")
    public ResponseEntity updateProduct(@PathVariable long productId, @RequestBody ProductDTO productDTO){
        return productService.updateProduct(productId, productDTO);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity deleteStudentById(@PathVariable long productId){
        productService.deleteStudentById(productId);
        return ResponseEntity.noContent().build();
    }
}
