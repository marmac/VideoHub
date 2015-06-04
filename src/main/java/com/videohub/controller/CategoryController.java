package com.videohub.controller;

import com.videohub.model.Category;
import com.videohub.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by: GiBSoN.
 * Created on: 2015-06-04.
 */
@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addCategory(@RequestBody @Valid Category category) {
        categoryService.addCategory(category);
    }
}
