package lt.ergo.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.ergo.restapi.entities.*;



public interface PersonRepository extends JpaRepository<Person, Integer>{
	Person findByfirstName(String firstName);
}