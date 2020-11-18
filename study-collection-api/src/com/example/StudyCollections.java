package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StudyCollections {

	public static void main(String[] args) {
		// 1. List: Duplicates, Ordered
		List<String> names = new ArrayList<>();
		// there are two implementations: ArrayList, LinkedList
		// ArrayList -> Array
		int[] numbers = { 4, 8, 15, 16, 23, 42 };
		// LinkedList -> [4] -> [8] ->[17]-> [15]
		// /\ | /\ |
		// |______| |______|
		System.out.println(numbers.length);
		System.out.println(numbers[3]);
		names.add("jack");
		names.add("kate");
		names.add("james");
		names.add("ben");
		names.add("kate");
		names.add(0, "jin");
		names.add("sun");
		names.add("kate");
		System.out.println(names.get(0));
		System.out.println(names.get(2));
		System.out.println(names.contains("jack"));
		names.sort(String::compareTo); // since java se 8
		// before java se8: Collections.sort(names);
		System.out.println(names);
		// 2. Set: Distinct, Unordered
		// HashSet, LinkedHashSet, TreeSet (Red-Black Tree)
		Comparator<String> dictionaryOrderDesc = (u, v) -> 0;
		// (u,v) ->
		// ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE);

		Set<String> set = new TreeSet<>(dictionaryOrderDesc);
		set.add("jack");
		set.add("kate");
		set.add("james");
		set.add("ben");
		set.add("kate");
		set.add("jin");
		set.add("sun");
		set.add("kate");
		set.add("ali");
		set.add("veli");
		System.out.println(set);
		System.out.println(set.contains("jack"));
		// Error: set is unordered -> you cannot ask for indexed elements
		// System.out.println(set.get(2));
		// Error: Set does not have sort method: set.sort()
		// 3. Map
		Map<String, Integer> areaCodes = new HashMap<>();
		Map<Integer, String> codeAreas = new HashMap<>();
		Map<String, List<Integer>> areaMultiCodes = new HashMap<>();
		areaMultiCodes.put("ankara", List.of(312));
		areaMultiCodes.put("istanbul", List.of(212, 216));
		areaCodes.put("ankara", 312);
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("istanbul-anadolu", 216);
		codeAreas.put(312, "ankara");
		codeAreas.put(212, "istanbul-avrupa");
		codeAreas.put(216, "istanbul-anadolu");
		System.out.println(areaCodes.get("istanbul-anadolu"));
		System.out.println(codeAreas.get(312));
		for (var entry : areaCodes.entrySet())
			if (entry.getValue() == 312)
				System.out.println(entry.getKey());
		System.out.println(areaMultiCodes.get("istanbul"));
	}

}
