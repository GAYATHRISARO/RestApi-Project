package com.furnitureapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Details {
	@Id
	@GeneratedValue(generator = "details_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "details_gen", sequenceName = "details_seq", initialValue = 1, allocationSize = 1)
	private Integer detailsId;
	@Column(length = 20)
	private String style;// Industrial,modern
	@Column(length = 20)
	private String material;// wood,plastic,fabric

	@OneToOne(mappedBy = "details", cascade = CascadeType.ALL)
	@JsonIgnore
	private Furniture furniture;

	public Details(String style, String material) {
		super();
		this.style = style;
		this.material = material;
	}

	@Override
	public String toString() {
		return "FurnitureDetails [style=" + style + ", material=" + material + "]";
	}

}
