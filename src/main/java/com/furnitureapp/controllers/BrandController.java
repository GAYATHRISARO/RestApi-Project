package com.furnitureapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureapp.exception.FurnitureNotFoundException;
import com.furnitureapp.model.Brand;
import com.furnitureapp.service.IBrandService;

/**
 * @author GayathriS
 *
 */
@RestController
@RequestMapping("/brand-api")
public class BrandController {

	@Autowired
	IBrandService brandService;

	@PostMapping("/brands")
	ResponseEntity<Brand> addBrand(@RequestBody Brand Brand) {
		Brand nBrand = brandService.addBrand(Brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Brand added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nBrand);
	}

	@PutMapping("/brands")
	ResponseEntity<String> updateBrand(@RequestBody Brand Brand) {
		brandService.updateBrand(Brand);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully!!");
	}

	@DeleteMapping("/brands/{BrandId}")
	ResponseEntity<String> deleteBrand(@PathVariable("BrandId") int BrandId) {
		brandService.deleteBrand(BrandId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}

	@GetMapping("/brands")
	ResponseEntity<List<Brand>> getAllBrand() {
		List<Brand> BrandList = brandService.getAll();
		return ResponseEntity.ok(BrandList);
	}

	@GetMapping("/brands/{brand}")
	ResponseEntity<List<Brand>> getByBrand(@PathVariable("brand") String brand) throws FurnitureNotFoundException {
		List<Brand> BrandByBrand = brandService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Brandlist By Brand");
		return ResponseEntity.ok().headers(headers).body(BrandByBrand);
	}

}
