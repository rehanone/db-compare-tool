package com.ubs.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ubs.example.model.Person;

@Component
public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(final ResultSet rs, final int rowNum) throws SQLException {
		final Person person = new Person();
		person.setName(rs.getString("NAME"));
		person.setAge(rs.getString("AGE"));
		return person;
	}
}
