package com.example.exercises;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise10 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
		
	public static void main(String[] args) {
		Comparator<Country> compareByGnp = comparing(Country::getGnp);
		Comparator<Country> compareByPopulation = comparing(Country::getPopulation);
		var compareByPopulationDesc = compareByPopulation.reversed();
		Consumer<Country> printCountry = System.out::println;
		Predicate<Country> asian = country -> "Asia".equals(country.getContinent());
		var allCountries = worldDao.findAllCountries();
		allCountries.stream().max(compareByGnp).ifPresent(printCountry);
		allCountries.stream().max(compareByPopulation).ifPresent(printCountry);
		var asianCountries = allCountries.stream().filter(asian).collect(toList());
		asianCountries.stream().sorted(compareByPopulationDesc).forEach(printCountry);
	}

}
