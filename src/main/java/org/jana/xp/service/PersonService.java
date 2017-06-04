package org.jana.xp.service;

import java.util.List;

import org.jana.xp.model.Person;

public interface PersonService {
	void addPerson(Person person);
	void updatePerson(Person person);
	List<Person> listPersons();
	Person getPersonById(int id);
	void removePerson(int id);
}
