package com.furnitureapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.Category;

/**
 * @author GayathriS
 *
 */
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	@Query("from Category where category=?1")
	List<Category> findByCategory(String category);

	@Query("from Category where category=?1 and categoryId=?2")
	List<Category> findByCategoryAndId(String category, int categoryId);

	@Query("from Category c inner join c.furnitureList f where c.category=?1 and f.name=?2 and f.price<=?3")
	List<Category> findByCategoryNameAndPrice(String category, String name, double price);
}
