package com.interview.programs.frequrntlyAsked.StringBased;

import java.util.stream.IntStream;

public class Palindrome {

    // two pointer approach to check if a string is a palindrome
    public String isPolindrome(String str) {
        int left = 0;
        int right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return "Not a Palindrome";
            }
            left++;
            right--;
        }
        return "Palindrome";
    }

    // Static method to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int n = s.length();
        return IntStream.range(0, n / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(n - i - 1));
    }



    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String str = "madam";
        String result = palindrome.isPolindrome(str);
        System.out.println("The string \"" + str + "\" is: " + result);

        str = "hello";
        result = palindrome.isPolindrome(str);
        System.out.println("The string \"" + str + "\" is: " + result);

        // Testing the static method
        String testString1 = "racecar";
        System.out.println("Is \"" + testString1 + "\" a palindrome? == " + isPalindrome(testString1));
    }
}
