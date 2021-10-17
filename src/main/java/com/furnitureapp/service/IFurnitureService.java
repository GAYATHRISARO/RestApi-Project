package com.furnitureapp.service;

import java.util.List;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Furniture;

/**
 * @author GayathriS
 *
 */
public interface IFurnitureService {
	Furniture addFurniture(Furniture furniture);

	Furniture updateFurniture(Furniture furniture);

	void deleteFurniture(int furnitureId);

	List<Furniture> getAll();

	Furniture getById(int furnitureId) throws IdNotFoundException;

	List<Furniture> getByDetailsStyleAndName(String style, String name);

	List<Furniture> getByDetailsMaterialAndPrice(String material, double price);

	List<Furniture> getByBrandAndName(String brand, String name) throws FurnitureNotFoundException;

	List<Furniture> getByPriceLessThan(double price) throws FurnitureNotFoundException;

}
