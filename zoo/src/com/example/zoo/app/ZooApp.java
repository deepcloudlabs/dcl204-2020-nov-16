package com.example.zoo.app;

import java.util.List;
import java.util.function.Consumer;

import com.example.zoo.domain.Animal;
import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Pet;
import com.example.zoo.domain.Spider;

public class ZooApp {

	public static void main(String[] args) {
		List<Animal> animals = List.of(
		    new Spider(),
		    new Cat("Garfield"),
		    new Spider(),
		    new Fish("Free Willy"),
		    new Spider(),
		    new Cat(),
		    new Fish("Jaws")
		);
		
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) { //GUARD
				Pet pet = (Pet) animal; //SAFE
				pet.play();
			}
		}
		Consumer<Animal> walk = Animal::walk;
		Consumer<Animal> eat = Animal::eat;
		Consumer<Animal> playIfPet = animal -> {
			if (animal instanceof Pet) ((Pet)animal).play();
		};
		animals.stream().parallel().forEach(walk.andThen(eat).andThen(playIfPet));
		int legs = animals.stream()
				          .filter(Pet.class::isInstance)
				          .mapToInt(Animal::getLegs)
				          .sum();
		System.out.println("# of legs (pet): "+legs);	
	}

}
