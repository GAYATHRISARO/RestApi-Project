package com.furnitureapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furnitureapp.model.Furniture;
/**
 * @author GayathriS
 *
 */
@Repository
public interface IFurnitureRepository extends JpaRepository<Furniture, Integer> {

	@Query("from Details d inner join d.furniture f where d.style=?1 and f.name=?2")
	List<Furniture> findByDetailsStyleAndName(String style, String name);

	@Query("from Furniture f inner join f.brandList b where b.brand=?1 and f.name=?2")
	List<Furniture> findByBrandAndName(String brand, String name);

	@Query("from Furniture where price<=?1")
	List<Furniture> findByPriceLessThan(double price);

	@Query("from Furniture where furnitureId=?1")
	public Furniture getById(int furnitureId);

	@Query("from Details d inner join d.furniture f where d.material=?1 and f.price<=?2")
	List<Furniture> findByDetailsMaterialAndPrice(String material, double price);

}
