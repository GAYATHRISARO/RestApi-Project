package com.furnitureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.furnitureapp.service.IBrandService;
import com.furnitureapp.service.ICategoryService;
import com.furnitureapp.service.IDetailsService;
import com.furnitureapp.service.IFurnitureService;

/**
 * @author GayathriS
 *
 */

@SpringBootApplication
public class SpringFurnitureappDatajpaApplication implements CommandLineRunner {

	@Autowired
	IFurnitureService furnitureService;

	@Autowired
	IDetailsService detailsService;

	@Autowired
	IBrandService brandService;

	@Autowired
	ICategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringFurnitureappDatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}

}
