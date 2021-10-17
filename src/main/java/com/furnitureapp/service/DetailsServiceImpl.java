package com.furnitureapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureapp.model.Details;
import com.furnitureapp.repository.IDetailsRepository;

/**
 * @author GayathriS
 *
 */
@Service
public class DetailsServiceImpl implements IDetailsService {

	IDetailsRepository detailsRepository;

	@Autowired
	public void setDetailsRepository(IDetailsRepository detailsRepository) {
		this.detailsRepository = detailsRepository;
	}

	@Override
	public Details addDetails(Details details) {
		return detailsRepository.save(details);
	}

	@Override
	public Details updateDetails(Details details) {
		return detailsRepository.save(details);
	}

	@Override
	public void deleteDetails(int detailsId) {
		detailsRepository.deleteById(detailsId);
	}

	@Override
	public List<Details> getAll() {
		return detailsRepository.findAll();
	}

	@Override
	public List<Details> getByStyleAndMaterial(String style, String material) {
		return detailsRepository.findByStyleAndMaterial(style, material);
	}

	@Override
	public List<Details> getByNameAndStyle(String name, String style) {
		return detailsRepository.findByNameAndStyle(name, style);
	}

	@Override
	public List<Details> getByNameAndMaterialPrice(String name, String material, double price) {
		return detailsRepository.findByNameAndMaterialPrice(name, material, price);
	}

}
