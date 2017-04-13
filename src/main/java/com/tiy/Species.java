package com.tiy;

/**
 * Created by josh on 4/12/17.
 */
public class Species {
	private Integer id;
	private String speciesType;

	public Species() {
	}

	public Species(Integer id, String species) {
		this.id = id;
		this.speciesType = species;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpeciesType() {
		return speciesType;
	}

	public void setSpeciesType(String species) {
		this.speciesType = species;
	}
}
