package com.interview.programs.frequrntlyAsked.StringBased;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ReverseString {

    //1. reverse a string using StringBuilder method
    //Fastest & Most Efficient
    public String reverseStringUsingStringBuildr(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        var reversedString = stringBuilder.reverse();
        return reversedString.toString();
    }

    //2. reverse a string using loop-1
    //Reverse the string without using charAt() or StringBuilder.
    public String reverseStringLoop1(String str) {
        int len = str.length();
        char[] arr = str.toCharArray();
        String temp = "";
        for (int i = len - 1; i >= 0; i--) {
            temp = temp + arr[i];
        }
        return temp;
    }

    //3. Reverse a String without loops
    // No in Built in methods like stringBuilder/stringBuffer
    public String reverseStringWithoutUsingLoops(String str) {
        return IntStream.range(0, str.length())
                .mapToObj(i -> str.charAt(str.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //4. while loop
    //Great Control & Slightly Lower Memory
    public String reverseWhileLoop(String input) {
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    public String reverseWhileLoop1(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char swap = chars[left];
            chars[left] = chars[right];
            chars[right] = swap;
            left++;
            right--;
        }
        return new String(chars);
    }

}
