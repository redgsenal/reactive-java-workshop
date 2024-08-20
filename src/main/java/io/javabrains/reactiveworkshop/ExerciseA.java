package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class ExerciseA {
    public static void main(String[] args) throws IOException {
        unchainMapSubscribe();
        chainMapSubscribe();
        System.out.println("Press a key to end");
        System.in.read();
    }

    private static void unchainMapSubscribe() {
        System.out.println("unchain map subscribe flux");
        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();
        integerFlux.map(value -> getMapValue(value));
        integerFlux.subscribe(System.out::println);
    }

    private static void chainMapSubscribe() {
        System.out.println("chain map subscribe flux");
        ReactiveSources.intNumbersFlux()
                .map(value -> getMapValue(value))
                .subscribe(System.out::println);
    }

    private static Integer getMapValue(Integer value) {
        return value + 10;
    }
}
