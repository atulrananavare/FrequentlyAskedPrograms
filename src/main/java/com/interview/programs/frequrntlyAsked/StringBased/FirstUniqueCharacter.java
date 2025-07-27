package com.interview.programs.frequrntlyAsked.StringBased;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstUniqueCharacter {

    public static Character firstNonRepeatingChar(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with frequency 1
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // Return null if no unique character found
        return null;
    }

    public static Optional<Character> firstUniqueCharStream(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> s.indexOf(ch) == s.lastIndexOf(ch))
                .findFirst();
    }


    public static void main(String[] args) {
        String input = "swiss";
        Character result = firstNonRepeatingChar(input);
        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        // Using Stream API
        Optional<Character> resultStream = firstUniqueCharStream(input);
        if (resultStream.isPresent()) {
            System.out.println("First unique character using Stream API: " + resultStream.get());
        } else {
            System.out.println("No unique character found using Stream API.");
        }
    }
}
