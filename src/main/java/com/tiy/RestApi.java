package com.tiy;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebMethod;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by josh on 3/24/17.
 */

/**
 * This is a RestController it is an annotation that adds @Controller and @ResponseBody together
 * on the class so you don't have to right both for your service.
 */
@RestController
public class RestApi {
	/**
	 * This is the Autowired Annotation this allow you to connect to other classes with out starting a new
	 * instance String will connect them for you automatically. Just make sure you add @Component to the class that
	 * are trying to access.
	 */
	@Autowired
	private AnimalRepository animalRepository;

	/**
	 * This is a POST Request Method Here where are getting Data from the
	 * webpage of and animal and then sending something back to the page
	 * @param animal
	 * @return
	 */
	@PostMapping ("/form")
	public String postNewAnimal (Animal animal) {
		System.out.println(animal.getBreed());

		animalRepository.addAnimal(animal);
		return "successfully Saved";
	}

	/**
	 * here is another example of a POST Request where i am collecting an ID
	 * then returning true to the page that data was received
	 */
	@PostMapping("/remove-animal")
	public boolean removeAnimal(Integer id){
		animalRepository.deleteAnimal(id);
		return true;
	}

	/**
	 * Within this Post I am using a @RequestParam annotation this allows us to
	 * specify item we are getting and what the value is
	 * Then I am sending back all of the breed with that ID
	 *
	 * @param id
	 * @return
	 */
	@PostMapping("/breeds")
	private List<Breed> getBreeds(@RequestParam("id") Integer id){
		return animalRepository.getBreeds(id);
	}
}
