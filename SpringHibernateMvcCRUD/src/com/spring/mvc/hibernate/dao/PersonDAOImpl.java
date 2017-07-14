package com.spring.mvc.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.mvc.hibernate.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;
	
	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Person").list();
	}

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Person.class, id));
	}

	@Override
	public List<Person> retrievePerson(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Person where name ='"+name+"'").list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
}
