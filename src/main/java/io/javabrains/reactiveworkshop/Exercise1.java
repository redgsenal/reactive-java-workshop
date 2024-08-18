package io.javabrains.reactiveworkshop;

import java.util.Arrays;
import java.util.Optional;

public class

Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        System.out.println("Use StreamSources.intNumbersStream()");
        StreamSources.intNumbersStream().forEach(n -> System.out.println(n));
        System.out.println("Use StreamSources.userStream()");
        StreamSources.userStream().forEach(user -> System.out.println(user));

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream().filter(i -> i <= 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        Arrays.stream(StreamSources.intNumbersStream().toArray(), 1, 3).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("Print the first number in intNumbersStream that's greater than 5. If nothing is found, print -1");
        Optional<Integer> first = StreamSources.intNumbersStream().filter(integer -> integer > 5).findFirst();
        first.ifPresentOrElse(v -> {
            System.out.println(v);
        }, () ->
        {
            System.out.println(-1);
        });

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().forEach(user -> {
            System.out.println(user.getFirstName());
        });

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.userStream().filter(user ->
                StreamSources.intNumbersStream().toList().contains(user.getId())
        ).toList().forEach(user -> System.out.println(user.getId() + " => " + user.getFirstName()));
    }

}
