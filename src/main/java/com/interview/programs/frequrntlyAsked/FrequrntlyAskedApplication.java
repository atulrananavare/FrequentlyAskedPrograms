package com.interview.programs.frequrntlyAsked;

import com.interview.programs.frequrntlyAsked.String.ReverseString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrequrntlyAskedApplication implements CommandLineRunner {

    public ReverseString reverseString;

    public FrequrntlyAskedApplication(ReverseString reverseString) {
        this.reverseString = reverseString;
    }

    public static void main(String[] args) {
        SpringApplication.run(FrequrntlyAskedApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String input = "JavaRocks";
        String reversed = reverseString.reverseStringUsingStringBuildr(input);
        System.out.println("Reversed: " + reversed);

        String reversedUsingLoop = reverseString.reverseStringLoop1(input);
        System.out.println("Reversed using loop1: " + reversedUsingLoop);

        String reverseStringUsingJava8 = reverseString.reverseStringWithoutUsingLoops(input);
        System.out.println("Reversed using java 8 : " + reverseStringUsingJava8);

        String reversedUsingWhileLoop = reverseString.reverseWhileLoop(input);
        System.out.println("Reversed using while loop: " + reversedUsingWhileLoop);
    }

}
