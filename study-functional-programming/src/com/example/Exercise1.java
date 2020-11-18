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
        // jack  -> kate  -> jin   -> ben   -> sun   -> james
        // 25000 -> 35000 -> 45000 -> 55000 -> 15000 -> 27000
        // accumulator: 202000 
        // (0.0,25000) -> 25000
        // (25000,35000) -> 60000
        // (60000,45000) -> 105000
        // (105000,55000) -> 160000
        // (160000,15000) -> 175000
        // (175000,27000) -> 202000
        // reduce() -> 202000
        double totalSalary = employees.stream()
        		                      .map(employee -> employee.getSalary())
        		                      .reduce(0.0, (sum,salary) -> sum+salary);
        System.out.println("Total salary is "+totalSalary+" \u20BA");
        employees.stream()
		         .map(Employee::getSalary)
		         .reduce(0.0, Double::sum);
        // Stream API methods: 
        //  i. intermediary methods: filter, map, distinct, limit, sorted, boxed, ...
        // ii. terminal methods: reduce, sum, count, min, max, findFirst, findAny, ...
        // Lazy Evaluation: terminal method triggers processing
        long count = employees.stream()
        		      .filter(employee -> employee.getDepartment()==Department.IT)
                      .count();
        System.out.println("# of employees in IT department is "+count);	
        count = employees.stream()
                 .map(Employee::getDepartment)
                 //.filter(department -> Department.IT.equals(department))
                 .filter(Department.IT::equals)
                 .count();
        count = employees.stream()
        		.map(Employee::getDepartment)
        		.filter(Department.IT::equals)
        		.map(department -> 1)
        		.reduce(0, Integer::sum);
        
	}
}
