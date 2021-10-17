package com.furnitureapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Category;
import com.furnitureapp.repository.ICategoryRepository;

/**
 * @author GayathriS
 *
 */
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Category getById(int categoryId) {
		return categoryRepository.findById(categoryId).get();
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> getByCategory(String category) {
		return categoryRepository.findByCategory(category);
	}

	@Override
	public List<Category> getByCategoryAndId(String category, int categoryId) throws IdNotFoundException {
		List<Category> categoryList = categoryRepository.findByCategoryAndId(category, categoryId);
		if (categoryList.isEmpty())
			throw new IdNotFoundException("Category Id not fuound");
		return categoryList;
	}

	@Override
	public List<Category> getByCategoryNameAndPrice(String category, String name, double price)
			throws FurnitureNotFoundException {
		List<Category> categoryList = categoryRepository.findByCategoryNameAndPrice(category, name, price);
		if (categoryList.isEmpty())
			throw new FurnitureNotFoundException("Category not fuound");
		return categoryList;
	}

}
