package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Exercise5 {

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Count the vowels used in words
	}

}
