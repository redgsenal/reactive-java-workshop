package io.javabrains.reactiveworkshop;

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
        StreamSources.intNumbersStream().filter(i -> i < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        // Arrays.stream(StreamSources.intNumbersStream().toArray(), 1, 3).forEach(System.out::println);
        StreamSources.intNumbersStream().filter(i -> i > 5).skip(1).limit(2).forEach(v -> {
            System.out.println(v);
        });

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5. If nothing is found, print -1");
        StreamSources.intNumbersStream().filter(integer -> integer > 5).findFirst().ifPresentOrElse(v -> System.out.println(v), () -> System.out.println(-1));
        // or
        System.out.println("or...");
        Integer i = StreamSources.intNumbersStream().filter(integer -> integer > 5).findFirst().orElse(-1);
        System.out.println(i);

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().forEach(user -> {
            System.out.println(user.getFirstName());
        });
        // or
        System.out.println("or...");
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(id -> user.getId() == id))
                .forEach(user -> System.out.println(user.getId() + " => " + user.getFirstName()));
        // or
        System.out.println("or...");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);
    }

}
