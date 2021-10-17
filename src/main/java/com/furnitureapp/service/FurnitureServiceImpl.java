package com.furnitureapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.repository.IFurnitureRepository;

/**
 * @author GayathriS
 *
 */
@Service
public class FurnitureServiceImpl implements IFurnitureService {

	IFurnitureRepository furnitureRepository;

	@Autowired
	public void setFurnitureRepository(IFurnitureRepository furnitureRepository) {
		this.furnitureRepository = furnitureRepository;
	}

	@Override
	public Furniture addFurniture(Furniture furniture) {
		return furnitureRepository.save(furniture);
	}

	@Override
	public Furniture updateFurniture(Furniture furniture) {
		return furnitureRepository.save(furniture);
	}

	@Override
	public void deleteFurniture(int furnitureId) {
		furnitureRepository.deleteById(furnitureId);
	}

	@Override
	public List<Furniture> getAll() {
		return furnitureRepository.findAll();
	}

	@Override
	public Furniture getById(int furnitureId) throws IdNotFoundException {
		return furnitureRepository.findById(furnitureId).get();
	}

	@Override
	public List<Furniture> getByDetailsStyleAndName(String style, String name) {
		return furnitureRepository.findByDetailsStyleAndName(style, name);
	}

	@Override
	public List<Furniture> getByDetailsMaterialAndPrice(String material, double price) {
		return furnitureRepository.findByDetailsMaterialAndPrice(material, price);
	}

	@Override
	public List<Furniture> getByPriceLessThan(double price) throws FurnitureNotFoundException {
		List<Furniture> furnitureList = furnitureRepository.findByPriceLessThan(price);
		if (furnitureList.isEmpty())
			throw new FurnitureNotFoundException("No furniture!!");
		return furnitureList;

	}

	@Override
	public List<Furniture> getByBrandAndName(String brand, String name) throws FurnitureNotFoundException {
		List<Furniture> furnitureList = furnitureRepository.findByBrandAndName(brand, name);
		if (furnitureList.isEmpty())
			throw new FurnitureNotFoundException("No furniture!!");
		return furnitureList;
	}

}
