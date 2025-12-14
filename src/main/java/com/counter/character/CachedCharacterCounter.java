package com.counter.character;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharacterCounter extends CharacterCounterDecorator {

	private final Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

	public CachedCharacterCounter(CharacterCounter charCounter) {
		super(charCounter);
	}

	@Override
	public Map<Character, Integer> countChars(String text) {
		return cache.computeIfAbsent(text, amountUniqueChars -> super.countChars(text));
	}
	
}