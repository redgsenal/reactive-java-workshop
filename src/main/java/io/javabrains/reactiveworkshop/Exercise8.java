package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        /*ReactiveSources.intNumbersFluxWithException().subscribe(value -> {
                    System.out.println(value);
                },
                error -> {
                    System.out.println(error.getMessage());
                },
                () -> {
                    System.out.println("complete");
                });*/

        /*ReactiveSources.intNumbersFluxWithException()
                .doOnError(error -> {
                    System.out.println(error.getMessage());
                })
                .subscribe(value -> {
                    System.out.println(value);
                });*/


        // Print values from intNumbersFluxWithException and continue on errors
/*        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((throwable, o) -> System.out.println(throwable.getMessage() + " " + o))
                .subscribe(value -> {
                    System.out.println(value);
                });*/

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(error -> Flux.just(-1, -2))
                .subscribe(value -> {
                    System.out.println(value);
                });

        System.out.println("Press a key to end");
        System.in.read();
    }

}
