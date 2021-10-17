package com.furnitureapp.service;

import java.util.List;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.model.Details;

/**
 * @author GayathriS
 *
 */
public interface IDetailsService {

	Details addDetails(Details details);

	Details updateDetails(Details details);

	void deleteDetails(int detailsId);

	List<Details> getAll();

	List<Details> getByStyleAndMaterial(String style, String material);

	List<Details> getByNameAndStyle(String name, String style);

	List<Details> getByNameAndMaterialPrice(String name, String material, double price) throws FurnitureNotFoundException;

}
