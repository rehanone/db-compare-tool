package com.ubs.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "/launch-context.xml", "/test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JobConfigurationTest {

	@Autowired
	private SimpleJdbcTemplate hsqldbJdbcTemplate;

	@Autowired
	private SimpleJdbcTemplate derbyJdbcTemplate;

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void test() throws Exception {
		assertNotNull(hsqldbJdbcTemplate);
		assertNotNull(derbyJdbcTemplate);
	}

	@Test
	public void launchJob() throws Exception {

		final JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);

	}
}
