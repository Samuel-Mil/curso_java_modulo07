package com.br.samuel.services;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.br.samuel.models.Person;

@Service
public class PersonService {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<>();
		logger.info("Finding all persons!");
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person findById(String id) {
		logger.info("Finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstname("Samuel");
		person.setLastname("Milhomens");
		person.setAddress("Casa 300 rua 15");
		person.setGender("masculino");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting person!");	
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstname("Person name "+ i);
		person.setLastname("Last name "+ i);
		person.setAddress("Casa "+ i +"rua 1"+ i);
		person.setGender("masculino");
		return person;
	}
}
