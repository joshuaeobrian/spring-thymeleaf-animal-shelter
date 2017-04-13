package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by josh on 4/3/17.
 *
 */

/**
 * This is a how you and where you would use the Component annotation
 * placing it here allows me to connect to this class where ever I
 * call it with @AutoWired
 */
@Component
public class AnimalRepository {
	/**
	 * This is how you would use JdbcTemplate
	 * this allows you to connect to your database
	 * after you configure your application properties
	 * see application.properties for how to set up connection
	 *
	 * also you can see that I used @AutoWired here to connect to it without
	 * having to make a new instance
	 */
	//starts connection to server
	@Autowired
	public JdbcTemplate template;

	/**
	 * Below are a hand full of methods that you the Template
	 * to connect to the database that i have configured and
	 * execute queries with. Currently you can see examples or Insert Select and Delete
	 * @return
	 */
	public List<Animal> getAnimals(){
		return template.query("SELECT a.id as id, a.animal_name AS name, b.breed_type as breed, s.species_type as species, a.age as age" +
				", g.gender_type as gender, a.description as description, a.receive_date as date" +
				"  FROM animal as a " +
				"  JOIN gender as g ON a.gender_id = g.id " +
				"  JOIN animal_type as at ON a.id = at.animal_id" +
				"  JOIN breed as b ON at.breed_id = b.id " +
				"  JOIN species as s on b.species_id = s.id;",(rs,i)->new Animal(rs.getInt("id"),
				rs.getString("name"),
				rs.getString("species"),
				rs.getString("breed"),
				rs.getInt("age"),
				rs.getString("gender"),
				rs.getString("description"),
				LocalDate.parse(rs.getString("date")),"cat1"));
	}

	//works
	public Animal getAnimalById(Integer id){
		return template.queryForObject("SELECT a.id as id, a.animal_name AS name, b.breed_type as breed, s.species_type as species, a.age as age" +
				", g.gender_type as gender, a.description as description, a.receive_date as date" +
				"  FROM animal as a " +
				"  JOIN gender as g ON a.gender_id = g.id " +
				"  JOIN animal_type as at ON a.id = at.animal_id" +
				"  JOIN breed as b ON at.breed_id = b.id " +
				"  JOIN species as s on b.species_id = s.id" +
				" where a.id = ?;",new Object[]{id},(rs,i)->new Animal(rs.getInt("id"),
				rs.getString("name"),
				rs.getString("species"),
				rs.getString("breed"),
				rs.getInt("age"),
				rs.getString("gender"),
				rs.getString("description"),
				LocalDate.parse(rs.getString("date")),"cat1"));
	}
	public List<Animal> getAnimalsBySpecies(Integer id){
		return template.query("SELECT a.id as id, a.animal_name AS name, b.breed_type as breed, s.species_type as species, a.age as age" +
				", g.gender_type as gender, a.description as description, a.receive_date as date" +
				"  FROM animal as a " +
				"  JOIN gender as g ON a.gender_id = g.id " +
				"  JOIN animal_type as at ON a.id = at.animal_id" +
				"  JOIN breed as b ON at.breed_id = b.id " +
				"  JOIN species as s on b.species_id = s.id" +
				"  WHERE s.id=?;",new Object[]{id},(rs,i)->new Animal(rs.getInt("id"),
				rs.getString("name"),
				rs.getString("species"),
				rs.getString("breed"),
				rs.getInt("age"),
				rs.getString("gender"),
				rs.getString("description"),
				LocalDate.parse(rs.getString("date")),"cat1"));
	}
	public void addAnimal(Animal animal){
		template.update("INSERT INTO animal(animal_name, age, description, receive_date, gender_id) VALUES (" +
				"    ?," +
				"    ?," +
				"    ?," +
				"    now()," +
				"   (SELECT id FROM gender WHERE gender_type=?))",new Object[]{animal.getName(),animal.getAge(),animal.getDescription(),animal.getGender()});

		template.update("INSERT INTO animal_type (animal_id, breed_id) VALUES (" +
				"(SELECT id FROM animal order by id desc LIMIT 1)," +
				"(SELECT id FROM breed where breed_type=?))",new Object[]{animal.getBreed()});

	}


	//works
	public List<Species> getSpecies() {
		return template.query("SELECT id, species_type from species order by species_type;",
				(rs,i)-> new Species(rs.getInt("id"), rs.getString("species_type")));
	}
	public List<Gender> getGender() {
		return template.query("SELECT id, gender_type from gender order by gender_type;",
				(rs,i)-> new Gender(rs.getInt("id"), rs.getString("gender_type")));
	}

	public void deleteAnimal(Integer id){
		template.update("DELETE FROM animal_type WHERE animal_id=?",new Object[]{id});

		template.update("DELETE FROM animal WHERE id=?",new Object[]{id});

	}

	public List<Breed> getBreeds(Integer id) {
		return template.query("Select id, breed_type from breed where species_id=?",new Object[]{id},
				(rs,i)-> new Breed(rs.getInt("id"),rs.getString("breed_type")));
	}
}
