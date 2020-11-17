package com.example.zoo.domain;

public class Cat extends Animal implements Pet {
	private String name;
	
	public Cat() { // no argument constructor
		super(4);
		name = "Tekir";
	}

	public Cat(String name) {
		super(4);
		this.name = name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		System.out.println(name + " is playing now...");
	}

	@Override
	public void eat() {
		System.out.println(name + " is eating now...");
	}

}
