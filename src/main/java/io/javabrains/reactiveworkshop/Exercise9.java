package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // non-blocking way to get the size of the Flux
       /* ReactiveSources.intNumbersFlux()
                .log()
                .count().subscribe(System.out::println);*/

        // Collect all items of intNumbersFlux into a single list and print it
        /*ReactiveSources.intNumbersFlux()
                .log()
                .collectList()
                .subscribe(System.out::println);*/

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .log()
                .map(lists -> lists.get(0) + lists.get(1))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
