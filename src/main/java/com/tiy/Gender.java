package com.tiy;

/**
 * Created by josh on 4/12/17.
 */
public class Gender {
	private Integer id;
	private String gender;

	public Gender() {
	}

	public Gender(Integer id, String gender) {
		this.id = id;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
