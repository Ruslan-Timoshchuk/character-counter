package com.counter.character;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text to count the number of chars");
            CharacterCounter charCounter = new CachedCharacterCounter(new UniqueCharacterCounter());
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                System.out.println(text);
                String amountChars = "\"%c\" - %d";
                charCounter.countChars(text)
                        .forEach((symbol, amount) -> System.out.println(String.format(amountChars, symbol, amount)));
            }
        }
    }

}