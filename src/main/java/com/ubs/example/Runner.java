package com.ubs.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ubs.example.dao.PersonDAO;
import com.ubs.example.model.Person;

public class Runner {

	private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

	public static void main(final String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext("/launch-context.xml");

		final PersonDAO personDao = context.getBean("personDao", PersonDAO.class);

		final List<Person> personsDerby = personDao.findAllDerby();
		for (final Person person : personsDerby) {
			LOG.info(person.toString());
		}

		final List<Person> personsHsqldb = personDao.findAllHsqldb();
		for (final Person person : personsHsqldb) {
			LOG.info(person.toString());
		}

	}
}