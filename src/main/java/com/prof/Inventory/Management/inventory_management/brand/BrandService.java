package com.prof.Inventory.Management.inventory_management.brand;

import com.prof.Inventory.Management.inventory_management.exception_handler.OtherNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAllBrands(){
        return brandRepository.findAll(Sort.by("name"));
    }

    public Optional<Brand> findBrandById(@PathVariable long brandId){
        return brandRepository.findById(brandId);
    }

    public long addNewBrand(@RequestBody @Valid Brand brand){
        return brandRepository.save(brand).getId();
    }

    public Brand updateBrand(@PathVariable long brandId, @RequestBody @Valid Brand brand){
        if (!brandRepository.existsById(brandId)) {
            String message = String.format("Brand with id '%s' does not exist", brandId);
            throw new OtherNotFoundException(message);
        }
        brand.setId(brandId);
        return brandRepository.save(brand);
    }

    public void deleteBrandById(@PathVariable long brandId){
        if (!brandRepository.existsById(brandId)) {
            String message = String.format("Brand with id '%s' does not exist", brandId);
            throw new OtherNotFoundException(message);
        }

        brandRepository.deleteById(brandId);
    }
}
