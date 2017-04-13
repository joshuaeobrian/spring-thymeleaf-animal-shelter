package com.tiy;

/**
 * Created by josh on 3/29/17.
 */
public class Breed {
	private Integer id;
	private String breed;

	public Breed() {
	}

	public Breed(Integer id, String breed) {
		this.id = id;
		this.breed = breed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
}
