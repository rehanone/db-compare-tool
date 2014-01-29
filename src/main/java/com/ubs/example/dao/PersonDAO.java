package com.ubs.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import com.ubs.example.mapper.PersonRowMapper;
import com.ubs.example.model.Person;

@Component("personDao")
public class PersonDAO {

	@Autowired
	@Qualifier("derbyJdbcTemplate")
	private SimpleJdbcTemplate template;

	@Autowired
	private PersonRowMapper mapper;

	public List<Person> findAllDerby() {

		final String sql = "SELECT * FROM PERSON";

		final List<Person> persons = template.query(sql, mapper);

		return persons;
	}

	public Person findByPersonName(final String name) {

		final String sql = "SELECT * FROM PERSON WHERE NAME = ?";

		final Person person = template.queryForObject(sql, new PersonRowMapper(), new Object[] { name });

		return person;
	}
}
