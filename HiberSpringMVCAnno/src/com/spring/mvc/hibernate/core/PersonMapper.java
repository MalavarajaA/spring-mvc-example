package com.spring.mvc.hibernate.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.hibernate.model.Person;


public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNo) throws SQLException {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setCountry(rs.getString("country"));
		return person;
	}

}
