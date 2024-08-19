package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5b {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        /*ReactiveSources.intNumbersFluxWithException().subscribe(value -> System.out.println(value),
                err -> {
                    System.out.println(err.getMessage());
                    //throw new RuntimeException("got an error");
                },
                () -> System.out.println("operation done"));*/

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.userFlux().subscribe(new BaseSubscriber<User>() {

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("subscription triggered...");
                request(1);
            }

            @Override
            protected void hookOnNext(User value) {
                System.out.println("hook on next: " + value.toString());
                request(1);
            }

        });

        System.out.println("Press a key to end");
        System.in.read();
    }

}