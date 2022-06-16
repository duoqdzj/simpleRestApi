package lt.ergo.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ergo.restapi.entities.Person;
import lt.ergo.restapi.repositories.PersonRepository;



@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;	
	
	public List<Person> getPerson(){
		return personRepository.findAll();
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPerson(Integer id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public Person updatePerson(Person s) {
		Person old=this.getPerson(s.getId());
		old.setFirstName(s.getFirstName());
		old.setLastName(s.getLastName());
		old.setPersonalID(s.getPersonalID());
		old.setDateOfBirth(s.getDateOfBirth());
		old.setGender(s.getGender());
		
		personRepository.save(old);
		return old;
	}
	
	public void deletePerson(Integer id) {
		personRepository.deleteById(id);
	}

	public Person findByfirstName(String firstName) {
		return personRepository.findByfirstName(firstName);
	}
}
