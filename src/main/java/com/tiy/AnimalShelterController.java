package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by josh on 3/24/17.
 */

/**
 * This is how you would use the @Controller
 * this allows me to direct all my pages to urls
 */
@Controller
public class AnimalShelterController {
	/**
	 * This is an instance of where I can use the @Autowired
	 * to connect to another class without having to create and manage
	 * instances off it along my application
	 */
	@Autowired
	private AnimalRepository animalRepository;

	/**
	 * Here I am using a RequestMap annotation to direct the browser to
	 * the root url which in this case is createAnimal.html
	 * I do not have to add the file extension because Spring knows
	 * what to access. The default method for RequestMapping is GET
	 * You can set any file to root best practice is index.html is root you
	 * can see this if you run index out of the static folder.
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("species",animalRepository.getSpecies());
		model.addAttribute("gender",animalRepository.getGender());
		return "createAnimal";
	}


	@RequestMapping("/animals")
	public String showIAnimals(Model model){

		model.addAttribute("animals",animalRepository.getAnimals());
		model.addAttribute("species",animalRepository.getSpecies());
		return "animalDisplay";
	}

	/**
	 * This is an example of a Get Request
	 * A Get Request requests data from something specific
	 * here you can see we are requesting from /animals/species
	 * in the url but also the in this url you need to provide more information
	 * ex: /animals/species?speciesid=1
	 * this would grab an animal out of the database where the id = 1
	 * @param model
	 * @param speciesid
	 * @return
	 */
	@GetMapping("/animals/species")
	public String showAnimalsWithSpecies(Model model,Integer speciesid){

		model.addAttribute("animals",animalRepository.getAnimalsBySpecies(speciesid));
		model.addAttribute("species",animalRepository.getSpecies());
		return "animalDisplay";
	}

//	@RequestMapping("/details")
//	public String showDetails(){
//		return "animalDetail";
//	}

	@RequestMapping("/detail")
	public String showAnimalWithId (Model model, Integer id){

		model.addAttribute("animal", animalRepository.getAnimalById(id));
		return "animalDetail";
	}
}
