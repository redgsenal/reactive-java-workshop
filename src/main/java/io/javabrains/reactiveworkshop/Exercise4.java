package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emists

        ReactiveSources.intNumberMono().subscribe(value -> {
            System.out.println("value: " + value);
        }, error -> {
            System.err.println("some error");
            error.printStackTrace();
        }, () -> {
            System.out.println("completed subscribe");
        });


        // Get the value from the Mono into an integer variable
        // this blocks the call
        Integer n = ReactiveSources.intNumberMono().block();
        int value = n.intValue();
        System.out.println("Integer: " + n);
        System.out.println("Integer value: " + value);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
