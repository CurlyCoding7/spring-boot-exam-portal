package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category addedCategory = this.categoryService.addCategory(category);

        return ResponseEntity.ok(addedCategory);

    }

    // update category
    @PutMapping("/")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){
        Category updatedCategory = this.categoryService.updateCategory(category);

        return ResponseEntity.ok(updatedCategory);

    }

    // delete category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);

    }

    // get category by id
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }


    // get all categories
    @GetMapping("/")
    public ResponseEntity<Set<Category>> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

}
