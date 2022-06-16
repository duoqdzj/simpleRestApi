package lt.ergo.restapi.restControllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.ergo.restapi.entities.Person;
import lt.ergo.restapi.services.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
	
	@CrossOrigin
	@GetMapping("/")
	public List<Person> index(){
		LOGGER.error("Message logged at INFO level");
		
		return personService.getPerson();
	}
	
	@CrossOrigin
	@PostMapping("/")
	public Person add(@RequestBody Person s)
	{
		return personService.savePerson(s);
	}
	
	@CrossOrigin
	@PatchMapping("/edit/{id}")
	public Person update(@PathVariable Integer id, @RequestBody Person s) {
		
		return personService.updatePerson(s);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public Boolean delete(@PathVariable Integer id) {
		personService.deletePerson(id);
		return true;
	}

}
