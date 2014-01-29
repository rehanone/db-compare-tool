package com.ubs.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/launch-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JobConfigurationTest {

	@Autowired
	private SimpleJdbcTemplate hsqldbJdbcTemplate;

	@Autowired
	private SimpleJdbcTemplate derbyJdbcTemplate;

	@Test
	public void launchJob() throws Exception {
		assertNotNull(hsqldbJdbcTemplate);
		assertNotNull(derbyJdbcTemplate);
	}
}
