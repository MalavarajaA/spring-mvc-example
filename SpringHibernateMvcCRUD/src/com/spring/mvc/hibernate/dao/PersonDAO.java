package com.spring.mvc.hibernate.dao;

import java.util.List;

import com.spring.mvc.hibernate.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);
	public List<Person> listPersons();
	public void deletePerson(int id);
	public List<Person> retrievePerson(String name);
}
