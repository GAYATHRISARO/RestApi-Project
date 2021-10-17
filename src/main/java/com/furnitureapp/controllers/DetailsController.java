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

import com.furnitureapp.model.Details;
import com.furnitureapp.service.IDetailsService;

/**
 * @author GayathriS
 *
 */
@RestController
@RequestMapping("/detail-api")
public class DetailsController {

	@Autowired
	IDetailsService detailsService;

	@PostMapping("/details")
	ResponseEntity<Details> addDetails(@RequestBody Details details) {
		Details ndetails = detailsService.addDetails(details);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Details added");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(ndetails);
	}

	@PutMapping("/details")
	ResponseEntity<String> updateDetails(@RequestBody Details details) {
		detailsService.updateDetails(details);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Updated Successfully!!");
	}

	@DeleteMapping("/details/{detailsId}")
	ResponseEntity<String> deleteDetails(@PathVariable("detailsId") int detailsId) {
		detailsService.deleteDetails(detailsId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
	}

	@GetMapping("/details")
	ResponseEntity<List<Details>> getAll() {
		List<Details> DetailsList = detailsService.getAll();
		return ResponseEntity.ok(DetailsList);
	}

	@GetMapping("/details/style/{style}/material/{material}")
	ResponseEntity<List<Details>> getByStyleAndMaterial(@PathVariable String style, @PathVariable String material) {
		List<Details> DetailsList = detailsService.getByStyleAndMaterial(style, material);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Detailslist By style ,material");
		return ResponseEntity.ok().headers(headers).body(DetailsList);

	}

	@GetMapping("/details/name/{name}/style/{style}")
	ResponseEntity<List<Details>> getByNameAndStyle(@PathVariable String name, @PathVariable String style) {
		List<Details> DetailsList = detailsService.getByNameAndStyle(name, style);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Detailslist By name,style");
		return ResponseEntity.ok().headers(headers).body(DetailsList);
	}

	@GetMapping("/details/name/{name}/material/{material}/price/{price}")
	ResponseEntity<List<Details>> getByNameAndMaterialPrice(String name, String material, double price) {
		List<Details> DetailsList = detailsService.getByNameAndMaterialPrice(name, material, price);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Detailslist By name,material,price");
		return ResponseEntity.ok().headers(headers).body(DetailsList);
	}
}
