package com.counter.character;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UniqueCharacterCounterTest {

    private final UniqueCharacterCounter uniqueCharacterCounter = new UniqueCharacterCounter();

    @Test
    void givenEmptyString_whenCountChars_thenEmptyMapIsReturned() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        assertEquals(expected, uniqueCharacterCounter.countChars(""));
    }

    @ParameterizedTest
    @CsvSource({ "' ', 1", 
                 "'  ', 2", 
                 "'     ', 5" })
    void givenOnlySpaces_whenCountChars_thenCorrectCountIsReturned(String text, int expectedCount) {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put(' ', expectedCount);
        assertEquals(expected, uniqueCharacterCounter.countChars(text));
    }

    @Test
    void givenSomeNonLetterChars_whenCountChars_thenCorrectCountIsReturned() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('h', 1);
        expected.put('e', 1);
        expected.put('2', 1);
        expected.put('0', 2);
        expected.put('l', 3);
        expected.put('o', 1);
        assertEquals(expected, uniqueCharacterCounter.countChars("he20lllo0"));
    }

    @Test
    void givenLettersInMixedCase_whenCountChars_thenCorrectCountIsReturned() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('m', 2);
        expected.put('K', 3);
        expected.put('f', 3);
        expected.put('M', 3);
        expected.put('O', 3);
        expected.put('o', 2);
        expected.put('F', 2);
        expected.put(' ', 2);
        expected.put('k', 3);
        assertEquals(expected, uniqueCharacterCounter.countChars("mKfMOfKoF KOkfMokF MkmO"));
    }

    @Test
    void givenSomeNonLetterCharsInMixedCase_whenCountChars_thenCorrectCountIsReturned() {
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('Y', 1);
        expected.put('4', 1);
        expected.put('a', 2);
        expected.put('!', 3);
        expected.put('j', 3);
        expected.put('E', 2);
        expected.put('e', 1);
        expected.put('m', 1);
        expected.put('A', 2);
        expected.put('T', 1);
        expected.put('1', 1);
        assertEquals(expected, uniqueCharacterCounter.countChars("Y4a!jEeE!amAT!j1jA"));
    }

    @Test
    void givenNull_whenCountChars_thenException() {
        assertThrows(NullPointerException.class, () -> uniqueCharacterCounter.countChars(null));
    }

}