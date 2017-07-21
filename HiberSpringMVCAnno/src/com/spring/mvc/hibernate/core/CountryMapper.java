package com.spring.mvc.hibernate.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.mvc.hibernate.model.Country;

public class CountryMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNo) throws SQLException {
		// TODO Auto-generated method stub
		Country country = new Country();
		country.setId(rs.getInt("id"));
		country.setCode(rs.getString("code"));
		country.setName(rs.getString("name"));
		return country;
	}

}
