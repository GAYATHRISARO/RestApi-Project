package com.furnitureapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author GayathriS
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Furniture {
	@Id
	@GeneratedValue(generator = "furniture_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "furniture_gen", sequenceName = "furniture_seq", initialValue = 1, allocationSize = 1)
	private Integer furnitureId;
	@Column(length = 20)
	private String name;// sofa,chair
	private Double price;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "details_id")
	Details details;// one to one

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "furniture_id")
	private Set<Brand> brandList;// many to one

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "furniture_category", joinColumns = { @JoinColumn(name = "furniture_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private Set<Category> categoryList;// many to many

	public Furniture(String name, Double price, Details details, Set<Brand> brandList, Set<Category> categoryList) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
		this.brandList = brandList;
		this.categoryList = categoryList;
	}



}
