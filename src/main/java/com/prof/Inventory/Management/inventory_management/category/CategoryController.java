package com.prof.Inventory.Management.inventory_management.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity findCategoryById(@PathVariable Long categoryId) {
        return new ResponseEntity(categoryService.findCategoryById(categoryId), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity addNewCategory(@RequestBody Category category) {
        return new ResponseEntity(categoryService.addNewCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable long categoryId, @RequestBody Category category) {
        return new ResponseEntity(categoryService.updateCategory(categoryId, category), HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable long categoryId) {
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.noContent().build();
    }
}
