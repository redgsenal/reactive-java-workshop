package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise6b {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        /*try {
            String v = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        // expected to have no response
        /*ReactiveSources.unresponsiveMono().subscribe(s -> {
            System.out.println("unresponsive: " + s);
        });*/

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        try {
            String v = ReactiveSources.unresponsiveFlux().blockFirst(Duration.ofSeconds(5));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Press a key to end");
        System.in.read();
    }

}
