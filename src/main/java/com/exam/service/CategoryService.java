package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Category;

public interface CategoryService {

    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);

    Category getCategory(Long categoryId);

    Set<Category> getCategories();

}
