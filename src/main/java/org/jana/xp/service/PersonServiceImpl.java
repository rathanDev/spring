package org.jana.xp.service;

import java.util.List;

import org.jana.xp.dao.PersonDao;
import org.jana.xp.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	@Transactional
	public void addPerson(Person person) {
		personDao.addPerson(person);
	}
	
	@Transactional
	public Person getPersonById(int id) {
		return personDao.getPersonById(id);
	}
	
	@Transactional
	public List<Person> listPersons() {
		return personDao.listPersons();
	};
	
	@Transactional
	public void removePerson(int id) {
		personDao.removePerson(id);
	}
	
	@Transactional
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}
	
}
