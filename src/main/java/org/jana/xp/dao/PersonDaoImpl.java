package org.jana.xp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jana.xp.model.Person;

public class PersonDaoImpl implements PersonDao{
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public void addPerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(person);
	};
	
	public Person getPersonById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = (Person)session.load(Person.class, new Integer(id));
		return person;
	}
	
	public List<Person> listPersons() {
		Session session = sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			System.out.println(p);
//			logger.info("Person List::"+p);
		}
		return personsList;
	}
	
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
	}
	
	public void updatePerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);	
	}
	
}
