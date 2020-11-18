package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        // ii. terminal methods: forEach, collect, reduce, sum, count, min, max, findFirst, findAny, ...
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
        // Department.IT -> {ben, james}
        // Department.SALES -> {sun}
        // Department.FINANCE -> {kate}
        // Department.MARKETING -> {jin} 
        // Department.HR -> {jack} 
        Map<Department, Long> departmentMap =
        		employees.stream()
                 .collect(Collectors.groupingBy(
                		 Employee::getDepartment,
                		 Collectors.counting()
                		));
        Consumer<Entry<Department, Long>> printEntry =
        		entry -> System.out.println(entry.getKey()+": "+entry.getValue()) ;
		departmentMap.entrySet().forEach(printEntry);
		employees.stream()
		         .sorted(Comparator.comparing(Employee::getSalary).reversed())
		         .forEach(System.out::println);
		employees.stream()
		         .sorted(Comparator.comparing(Employee::getSalary).reversed())
		         .findFirst()
		         .ifPresent(System.out::println);   		         
		employees.stream()
		         .max(Comparator.comparing(Employee::getSalary))
		         .ifPresent(System.out::println);   
		employees.stream()
				.min(Comparator.comparing(Employee::getSalary))
				.ifPresent(System.out::println); 
		Comparator<Employee> maxBySalary = 
				Comparator.comparing(Employee::getSalary);
		employees.stream()
		         .collect(Collectors.groupingBy(Employee::getGender,Collectors.maxBy(maxBySalary)))
		         .forEach((gender,emp)->emp.ifPresent(employee -> System.out.println(gender+": "+employee)));
	}
}
