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
import com.furnitureapp.exception.IdNotFoundException;
import com.furnitureapp.model.Brand;
import com.furnitureapp.model.Category;
import com.furnitureapp.model.Details;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.service.IBrandService;
import com.furnitureapp.service.ICategoryService;
import com.furnitureapp.service.IDetailsService;
import com.furnitureapp.service.IFurnitureService;

/**
 * @author GayathriS
 *
 */
@RestController
@RequestMapping("/furniture-api")
public class FurnitureController {
	@Autowired
	IFurnitureService furnitureService;

	@Autowired
	IBrandService brandService;

	@Autowired
	ICategoryService categoryService;

	@Autowired
	IDetailsService detailsService;

	@PostMapping("/furnitures")
	ResponseEntity<Furniture> addFurniture(@RequestBody Furniture furniture) {
		Furniture nfurniture = furnitureService.addFurniture(furniture);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Furniture added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nfurniture);
	}

	@PutMapping("/furnitures")
	ResponseEntity<String> updateFurniture(@RequestBody Furniture furniture) {
		furnitureService.updateFurniture(furniture);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully!!");
	}

	@DeleteMapping("/furnitures/{furnitureId}")
	ResponseEntity<String> deleteFurniture(@PathVariable("furnitureId") int furnitureId) {
		furnitureService.deleteFurniture(furnitureId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}

	@GetMapping("/furnitures")
	ResponseEntity<List<Furniture>> getAllFurniture() {
		List<Furniture> furnitureList = furnitureService.getAll();
		return ResponseEntity.ok(furnitureList);
	}

	@GetMapping("/furnitures/{furnitureId}")
	ResponseEntity<Furniture> getById(@PathVariable("furnitureId") int id) throws IdNotFoundException {
		Furniture furniture = furnitureService.getById(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniture By Id");
		headers.add("info", "Returning one furniture");
		ResponseEntity<Furniture> furnitureResponse = new ResponseEntity<Furniture>(furniture, headers, HttpStatus.OK);
		return furnitureResponse;
	}

	@GetMapping("/furnitures/material/{material}/price/{price}")
	ResponseEntity<List<Furniture>> getByDetailsMaterialPrice(@PathVariable("material") String material,
			@PathVariable("price") double price) {
		List<Furniture> furnitureByMaterialPrice = furnitureService.getByDetailsMaterialAndPrice(material, price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By Material and Price");
		return ResponseEntity.ok().headers(headers).body(furnitureByMaterialPrice);
	}

	@GetMapping("/furnitures/price/{price}")
	ResponseEntity<List<Furniture>> getByPriceLessThan(@PathVariable("price") double price)
			throws FurnitureNotFoundException {
		List<Furniture> furnitureByPrice = furnitureService.getByPriceLessThan(price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By price");
		return ResponseEntity.ok().headers(headers).body(furnitureByPrice);
	}

	// *
	@GetMapping("/furnitures/style/{style}/name/{name}")
	ResponseEntity<List<Furniture>> getByDetailsStyleName(@PathVariable("style") String style,
			@PathVariable("name") String name) {
		List<Furniture> furnitureByStyleName = furnitureService.getByDetailsStyleAndName(style, name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By Style and Name");
		return ResponseEntity.ok().headers(headers).body(furnitureByStyleName);

	}

	@GetMapping("/furnitures/brand/{brand}/name/{name}")
	ResponseEntity<List<Furniture>> getByBrandName(@PathVariable("brand") String brand,
			@PathVariable("name") String name) throws FurnitureNotFoundException {
		List<Furniture> furnitureByBrandName = furnitureService.getByBrandAndName(brand, name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By Brand and Name");
		return ResponseEntity.ok().headers(headers).body(furnitureByBrandName);
	}

	@GetMapping("/furnitures/brand/{brand}")
	ResponseEntity<List<Brand>> getByBrand(@PathVariable("brand") String brand) throws FurnitureNotFoundException {
		List<Brand> furnitureByBrand = brandService.getByBrand(brand);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By Brand");
		return ResponseEntity.ok().headers(headers).body(furnitureByBrand);
	}

	@GetMapping("/furnitures/category/{category}")
	ResponseEntity<List<Category>> getByCategory(@PathVariable("category") String category) {
		List<Category> furnitureByCategory = categoryService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By Category");
		return ResponseEntity.ok().headers(headers).body(furnitureByCategory);
	}

	@GetMapping("/details/style/{style}/material/{material}")
	ResponseEntity<List<Details>> getByStyleAndMaterial(@PathVariable("style") String style,
			@PathVariable("material") String material) {
		List<Details> furnitureByStyleMaterial = detailsService.getByStyleAndMaterial(style, material);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Furniturelist By Style and Material");
		return ResponseEntity.ok().headers(headers).body(furnitureByStyleMaterial);
	}
}
