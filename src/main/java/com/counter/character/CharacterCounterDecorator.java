package com.counter.character;

import java.util.Map;

public class CharacterCounterDecorator implements CharacterCounter {

	private final CharacterCounter characterCounter;

	public CharacterCounterDecorator(CharacterCounter charCounter) {
		this.characterCounter = charCounter;
	}

	@Override
	public Map<Character, Integer> countChars(String text) {
		return characterCounter.countChars(text);
	}
	
}