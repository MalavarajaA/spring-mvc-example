package com.spring.mvc.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.hibernate.dao.PersonDAO;
import com.spring.mvc.hibernate.model.Country;
import com.spring.mvc.hibernate.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public List<Person> retrievePerson(String name) {
		// TODO Auto-generated method stub
		return this.personDAO.retrievePerson(name);
	}

	@Override
	@Transactional
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		this.personDAO.deletePerson(id);
	}
	
	@Override
	@Transactional
	public boolean isPersonExist(String name){
		return this.personDAO.isPersonExist(name);
	}

	@Override
	@Transactional
	public List<Country> readCountries() {
		// TODO Auto-generated method stub
		return this.personDAO.readCountries();
	}

}
