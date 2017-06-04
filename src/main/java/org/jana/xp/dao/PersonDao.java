package org.jana.xp.dao;

import org.jana.xp.model.Person;

import java.util.*;

public interface PersonDao {
	void addPerson(Person person);
	void updatePerson(Person person);
	List<Person> listPersons();
	Person getPersonById(int id);
	void removePerson(int id);
}
