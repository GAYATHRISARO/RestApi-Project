package com.furnitureapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.Details;

/**
 * @author GayathriS
 *
 */
@Repository
public interface IDetailsRepository extends JpaRepository<Details, Integer> {

	@Query("from Details where style=?1 and material=?2")
	List<Details> findByStyleAndMaterial(String style, String material);

	@Query("from Details d inner join d.furniture f where f.name=?1 and d.style=?2")
	List<Details> findByNameAndStyle(String name, String style);

	@Query("from Details d inner join d.furniture f where f.name=?1 and d.material=?2 and f.price<=?3")
	List<Details> findByNameAndMaterialPrice(String name, String material, double price);

}
