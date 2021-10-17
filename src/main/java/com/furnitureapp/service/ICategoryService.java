package com.furnitureapp.service;

import java.util.List;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Category;

/**
 * @author GayathriS
 *
 */
public interface ICategoryService {

	Category addCategory(Category category);

	Category updateCategory(Category category);

	void deleteCategory(int categoryId);

	List<Category> getAll();

	Category getById(int categoryId);

	List<Category> getByCategory(String category);

	List<Category> getByCategoryAndId(String category, int categoryId) throws IdNotFoundException;

	List<Category> getByCategoryNameAndPrice(String category, String name, double price)
			throws FurnitureNotFoundException;
}
