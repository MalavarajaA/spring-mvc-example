package com.spring.mvc.hibernate.dao;

import java.util.List;

import javax.sql.DataSource;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.hibernate.core.CountryMapper;
import com.spring.mvc.hibernate.core.PersonMapper;
import com.spring.mvc.hibernate.model.Country;
import com.spring.mvc.hibernate.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		String query = "insert into Person(name,country) values(?,?)";
		Object input[] = new Object[] { p.getName(), p.getCountry() };
		jdbcTemplate.update(query, input);
	}

	@Override
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		String query = "Select * from Person";
		List<Person> persons = jdbcTemplate.query(query, new PersonMapper());
		return persons;
	}

	@Override
	public List<Person> retrievePerson(String name) {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		String query = "Select * from Person where name like '%" + name + "%'";
		List<Person> persons = jdbcTemplate.query(query, new PersonMapper());
		return persons;
	}

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		String query = "delete from Person where id=" + id;
		jdbcTemplate.update(query);
	}

	@Override
	public boolean isPersonExist(String name) {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		String sql = "Select * from Person where name like '%" + name + "%'";
		List<Person> persons = jdbcTemplate.query(sql, new PersonMapper());

		return persons.size() == 0 ? true : false;
	}

	@Override
	public List<Country> readCountries() {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(this.dataSource);
		String sql = "Select * from Country";
		List<Country> countrys = jdbcTemplate.query(sql, new CountryMapper());
		return countrys;
	}

	/*
	 * private SessionFactory sessionFactory;
	 * 
	 * public SessionFactory getSessionFactory() { return sessionFactory; }
	 * 
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * @Override public void addPerson(Person p) { // TODO Auto-generated method
	 * stub Session session = sessionFactory.getCurrentSession();
	 * session.persist(p); }
	 * 
	 * @Override public List<Person> listPersons() { // TODO Auto-generated
	 * method stub Session session = sessionFactory.getCurrentSession(); return
	 * session.createQuery("from Person").list(); }
	 * 
	 * @Override public List<Person> retrievePerson(String name) { // TODO
	 * Auto-generated method stub Session session =
	 * sessionFactory.getCurrentSession(); return
	 * session.createQuery("from Person where name like '%"+name+"%'").list(); }
	 * 
	 * @Override public void deletePerson(int id) { // TODO Auto-generated
	 * method stub Session session = sessionFactory.getCurrentSession();
	 * session.delete(session.get(Person.class, id)); }
	 * 
	 * @Override public boolean isPersonExist(String name){
	 * 
	 * Session session = sessionFactory.getCurrentSession(); List<Person>
	 * persons =
	 * session.createQuery("from Person where name like '%"+name+"%'").list();
	 * 
	 * return persons.size() == 0 ? true : false;
	 * 
	 * }
	 * 
	 * @Override public List<Country> readCountries() { // TODO Auto-generated
	 * method stub Session session = sessionFactory.getCurrentSession();
	 * List<Country> countrys = session.createQuery("from Country").list();
	 * return countrys; }
	 */

}
