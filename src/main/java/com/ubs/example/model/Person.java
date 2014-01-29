package com.ubs.example.model;

public class Person {

	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(final String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
