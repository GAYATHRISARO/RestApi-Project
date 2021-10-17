package com.furnitureapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author GayathriS
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {

	@Id
	@GeneratedValue(generator = "brand_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen", sequenceName = "brand_seq", initialValue = 1, allocationSize = 1)
	private Integer brandId;
	@Column(length = 20)
	private String brand;// casacraft,woodsworth

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "furniture_id")
	private Furniture furniture;// many to one

	public Brand(String brand, Furniture furniture) {
		super();
		this.brand = brand;
		this.furniture = furniture;
	}

	public Brand(String brand) {
		super();
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Brand [brand=" + brand + ", furniture=" + furniture + "]";
	}

}
