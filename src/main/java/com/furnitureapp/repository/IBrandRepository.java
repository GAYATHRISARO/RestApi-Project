package com.furnitureapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.Brand;

/**
 * @author GayathriS
 *
 */
@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {

	@Query("from Brand where brand=?1")
	List<Brand> findByBrand(String brand);

}
