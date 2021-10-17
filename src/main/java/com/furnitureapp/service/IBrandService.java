package com.furnitureapp.service;

import java.util.List;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.model.Brand;

/**
 * @author GayathriS
 *
 */
public interface IBrandService {

	Brand addBrand(Brand brand);

	Brand updateBrand(Brand brand);

	void deleteBrand(int brandId);

	List<Brand> getAll();

	List<Brand> getByBrand(String brand) throws FurnitureNotFoundException;

}
