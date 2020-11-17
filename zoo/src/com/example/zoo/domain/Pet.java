package com.example.zoo.domain;

public abstract interface Pet {
	abstract public void setName(String name);
	String getName();
	abstract void play();
}
