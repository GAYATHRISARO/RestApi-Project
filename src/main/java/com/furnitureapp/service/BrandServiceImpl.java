package com.furnitureapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furnitureapp.model.Brand;
import com.furnitureapp.repository.IBrandRepository;

/**
 * @author GayathriS
 *
 */
@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	IBrandRepository brandRepository;

	@Override
	public Brand addBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand updateBrand(Brand brand) {
		return brandRepository.save(brand);

	}

	@Override
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
	}

	@Override
	public List<Brand> getAll() {
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getByBrand(String brand) {
		return brandRepository.findByBrand(brand);
	}

}
