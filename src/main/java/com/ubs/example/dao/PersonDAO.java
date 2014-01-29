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
	private SimpleJdbcTemplate derby;

	@Autowired
	@Qualifier("hsqldbJdbcTemplate")
	private SimpleJdbcTemplate hsqldb;

	@Autowired
	private PersonRowMapper mapper;

	public List<Person> findAllDerby() {

		final String sql = "SELECT * FROM PERSON";

		final List<Person> persons = derby.query(sql, mapper);

		return persons;
	}

	public List<Person> findAllHsqldb() {

		final String sql = "SELECT * FROM PERSON";

		final List<Person> persons = hsqldb.query(sql, mapper);

		return persons;
	}
}
