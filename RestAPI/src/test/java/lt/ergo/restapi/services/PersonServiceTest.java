package lt.ergo.restapi.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.ergo.restapi.entities.Person;
import lt.ergo.restapi.repositories.PersonRepository;

class PersonServiceTest {

	@SpringBootTest
	@TestMethodOrder(OrderAnnotation.class)
	class ProductdataApplicationTests {

		@Autowired
		PersonRepository personRepository;
		
		@Test
		@Order(1)
		public void testCreate () {
			Person p = new Person();
			p.setId(111);
			p.setFirstName("Test");
			p.setLastName("TestTest");
			p.setPersonalID("222222");
			p.setDateOfBirth("20220616");
			p.setGender("male");
			personRepository.save(p);
			assertNotNull(personRepository.findById(111).get());
		}
			
		@Test
		@Order(2)
		public void testReadAll () {
			List list = personRepository.findAll();
			assertThat(list).size().isGreaterThan(0);
		}
			
		@Test
		@Order(3)
		public void testRead () {
			Person person = personRepository.findById(111).get();
			assertEquals("Test", person.getFirstName());
		}
			
		@Test
		@Order(4)
		public void testUpdate () {
			Person p = personRepository.findById(111).get();
			p.setPersonalID("333333");
			personRepository.save(p);
			assertNotEquals("222222", personRepository.findById(111).get().getPersonalID());
		}
			
		@Test
		@Order(5)
		public void testDelete () {
			personRepository.deleteById(111);
			assertThat(personRepository.existsById(111)).isFalse();
		}
	}
	
}