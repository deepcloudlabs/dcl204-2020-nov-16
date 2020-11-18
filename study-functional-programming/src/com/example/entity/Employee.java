package com.example.entity;

public class Employee {
	private String identity;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double salary;
	private Gender gender;
	private Department department;



	public Employee(String identity, String firstName, String lastName, int birthYear, double salary, Gender gender,
			Department department) {
		this.identity = identity;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.salary = salary;
		this.gender = gender;
		this.department = department;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", firstName=" + firstName + ", lastName=" + lastName + ", birthYear="
				+ birthYear + ", salary=" + salary + ", gender=" + gender + ", department=" + department + "]";
	}

}
