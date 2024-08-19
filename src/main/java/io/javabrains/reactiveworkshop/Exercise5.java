package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(value -> System.out.println(value),
                err -> {
                    System.out.println(err.getMessage());
                    //throw new RuntimeException("got an error");
                },
                () -> System.out.println("operation done"));

        // Subscribe to a flux using an implementation of BaseSubscriber


        System.out.println("Press a key to end");
        System.in.read();
    }

}