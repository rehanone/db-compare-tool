package com.ubs.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ubs.example.dao.PersonDAO;
import com.ubs.example.model.Person;

@Component
public class PersonProcessor implements ItemProcessor<Person, String> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonProcessor.class);

	@Autowired
	private PersonDAO personDAO;

	@Override
	public String process(final Person person) throws Exception {
		LOG.info("Reading person from derby" + person.toString());

		final Person personHsqldb = personDAO.findByPersonName(person.getName());

		LOG.info("Reading person from hsqldb" + personHsqldb.toString());

		return person.equals(personHsqldb) ? "Matched person name: " + person.getName() : "Not matched person name: "
				+ person.getName();
	}
}