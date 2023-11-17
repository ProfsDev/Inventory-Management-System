package com.prof.Inventory.Management.inventory_management.brand;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> findAllBrands(){
        return brandService.findAllBrands();
    }

    @GetMapping("/{brandId}")
    public ResponseEntity findBrandById(@PathVariable long brandId){
        return new ResponseEntity(brandService.findBrandById(brandId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity addNewBrand(@Valid @RequestBody Brand brand){
        return new ResponseEntity(brandService.addNewBrand(brand), HttpStatus.CREATED);
    }

    @PutMapping("/{brandId}")
    public ResponseEntity updateBrand(@PathVariable long brandId, @RequestBody Brand brand){
        return new ResponseEntity(brandService.updateBrand(brandId, brand), HttpStatus.OK);
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity deleteBrandById(@PathVariable long brandId){
        brandService.deleteBrandById(brandId);
        return ResponseEntity.noContent().build();
    }
}
