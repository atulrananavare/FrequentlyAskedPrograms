package com.interview.programs.frequrntlyAsked.String;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RemoveDuplicates {

    public static String removeDuplicatesUsingSet(String input) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (seen.add(c)) {  // only adds if not already present
                result.append(c);
            }
        }
        return result.toString();
    }

    // Method to remove duplicates while maintaining case insensitivity
    public static String removeDuplicatesCaseInsensitive(String input) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            char lower = Character.toLowerCase(c);
            if (seen.add(lower)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Method to remove duplicates without maintaining order
    // This will not maintain the order of characters
    public static String removeDuplicatesUnordered(String input) {
        return new java.util.HashSet<Character>() {{
            for (char c : input.toCharArray()) add(c);
        }}.stream().map(String::valueOf).collect(Collectors.joining());
    }


    // Method to remove duplicates using Java Streams
    // This will maintain the order of first occurrence
    public static String removeDuplicatesStream(String input) {
        Set<Character> seen = new HashSet<>();

        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(seen::add)  // only pass if not seen before
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String input = "Banana";
        String result = removeDuplicatesUsingSet(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);  // Output: "JavaRocks"

        String caseInsensitiveInput = "Navjeevan";
        String caseInsensitiveResult = removeDuplicatesCaseInsensitive(caseInsensitiveInput);
        System.out.println("Case Insensitive Input: " + caseInsensitiveInput);
        System.out.println("Case Insensitive Output: " + caseInsensitiveResult);  // Output: "Ban"

        String unorderedInput = "Banana";
        String unorderedResult = removeDuplicatesUnordered(unorderedInput);
        System.out.println("Unordered Input: " + unorderedInput);
        System.out.println("Unordered Output: " + unorderedResult);  // Output: "Ban"

        String streamInput = "Banana";
        String streamResult = removeDuplicatesStream(streamInput);
        System.out.println("Stream Input: " + streamInput);
        System.out.println("Stream Output: " + streamResult);  // Output: "Ban"
    }
}
