package com.spring.mvc.hibernate.service;

import java.util.List;

import com.spring.mvc.hibernate.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public List<Person> listPersons();
	public List<Person> retrievePerson(String name);
	public void deletePerson(int id);
	public boolean isPersonExist(String name);
}
