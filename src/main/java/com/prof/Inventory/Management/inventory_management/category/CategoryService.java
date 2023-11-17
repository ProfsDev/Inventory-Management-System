package com.prof.Inventory.Management.inventory_management.category;

import com.prof.Inventory.Management.inventory_management.exception_handler.OtherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        List<Category> categoryList = categoryRepository.findAll(Sort.by("name"));

        if (categoryList.isEmpty()) {
            String errorMessage = "No category found";
            throw new OtherNotFoundException(errorMessage);
        }

        return categoryList;
    }

    public Optional<Category> findCategoryById(Long categoryId) {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);

        if (!categoryOptional.isPresent()) {
            String errorMessage = String.format("Category with id %s not found", categoryId);
            throw new OtherNotFoundException(errorMessage);
        }

        return categoryOptional;
    }

    public Long addNewCategory(Category category) {
        return categoryRepository.save(category).getId();
    }

    public Category updateCategory(long categoryId, Category category) {
        if (!categoryRepository.existsById(categoryId)) {
            String errorMessage = String.format("Category with id %s not found", categoryId);
            throw new OtherNotFoundException(errorMessage);
        }
        category.setId(categoryId);
        return categoryRepository.save(category);

    }

    public void deleteCategoryById(long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            String errorMessage = String.format("Category id '%s' does not exist", categoryId);
            throw new OtherNotFoundException(errorMessage);
        }
        categoryRepository.deleteById(categoryId);
    }

}
