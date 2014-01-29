package com.ubs.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class PersonWriter implements ItemWriter<String> {

	private static final Logger LOG = LoggerFactory.getLogger(PersonWriter.class);

	@Override
	public void write(final List<? extends String> items) throws Exception {
		for (final String item : items) {
			LOG.info(item);
		}
	}
}