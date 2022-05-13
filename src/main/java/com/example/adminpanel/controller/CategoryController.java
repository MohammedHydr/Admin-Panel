package com.example.adminpanel.controller;

import com.example.adminpanel.service.CategoryService;
import com.example.adminpanel.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // handler method to handle list cat amd return model and view
    @GetMapping("/categories")
    public String listCategories(Model model){
        //keys and values , access this key using thymeleaf syntax ${listCategories}
        model.addAttribute("listCategories", categoryService.getAllCategories());
        return "category/categories"; // name of the html file
    }

    @GetMapping("/categories/new")
    public String createCategoriesForm(Model model){
        // create user object to hold user from data
        Category category = new Category();
        model.addAttribute("addCategory",category);
        return "category/create_category";
    }

    @PostMapping("/categories")
    public String saveCategory(@ModelAttribute("categories") Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategoryForm(@PathVariable Long id, Model model){
        model.addAttribute("editCategory", categoryService.getCategoryById(id));
        return "category/edit_category";
    }

    @PostMapping("/categories/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute("updateCategory") Category category, Model model){
        //get user from database by id
        Category existingCategory = categoryService.getCategoryById(id);
        existingCategory.setId(id);
        existingCategory.setName(category.getName());

        categoryService.updateCategory(existingCategory);
        return "redirect:/categories";
    }

    //handler method to handle delete user request
    @GetMapping("/categories/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
