package com.furnitureapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureapp.model.Category;
import com.furnitureapp.service.ICategoryService;

/**
 * @author GayathriS
 *
 */
@RestController
@RequestMapping("/category-api")
public class CategoryController {

	@Autowired
	ICategoryService categoryService;

	@PostMapping("/categories")
	ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category nCategory = categoryService.addCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Category added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nCategory);
	}

	@PutMapping("/categories")
	ResponseEntity<String> updateCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully!!");
	}

	@DeleteMapping("/categories/{categoryId}")
	ResponseEntity<String> deleteCategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}

	@GetMapping("/categories")
	ResponseEntity<List<Category>> getAllCategory() {
		List<Category> CategoryList = categoryService.getAll();
		return ResponseEntity.ok(CategoryList);
	}
	
	@GetMapping("/categories/category/{category}/categoryId/{categoryId}")
	ResponseEntity<List<Category>> getByCategoryAndId(@PathVariable("category")String category,@PathVariable("categoryId") int categoryId){
		List<Category> CategoryList = categoryService.getByCategoryAndId(category, categoryId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Categorylist By category and id");
		return ResponseEntity.ok().headers(headers).body(CategoryList);
	}

	@GetMapping("/categories/category/{category}/name/{name}/price/{price}")
	ResponseEntity<List<Category>> getByCategoryNameAndPrice(@PathVariable("category")String category,@PathVariable("name") String name,@PathVariable("price") double price){
		List<Category> CategoryList = categoryService.getByCategoryNameAndPrice(category, name, price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Categorylist By category, name and price");
		return ResponseEntity.ok().headers(headers).body(CategoryList);
	}

}


