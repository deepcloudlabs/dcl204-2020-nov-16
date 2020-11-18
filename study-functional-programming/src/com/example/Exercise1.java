package com.example;

import java.util.List;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Gender;

public class Exercise1 {
	public static void main(String[] args) {
        List<Employee> employees = List.of(
        		new Employee("1", "jack", "bauer", 1956, 25_000.,Gender.MALE, Department.HR),
        		new Employee("2", "kate", "austen", 1978, 35_000.,Gender.FEMALE, Department.FINANCE),
        		new Employee("3", "jin", "kwon", 1976, 45_000.,Gender.FEMALE, Department.MARKETING),
        		new Employee("4", "ben", "linus", 1954, 55_000.,Gender.MALE, Department.IT),
        		new Employee("5", "sun", "kwon", 1973, 15_000.,Gender.MALE, Department.SALES),
        		new Employee("6", "james", "sawyer", 1980, 27_000.,Gender.MALE, Department.IT)
        );
	}
}
