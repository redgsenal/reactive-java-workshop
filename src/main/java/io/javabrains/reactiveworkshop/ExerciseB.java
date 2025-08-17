package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

public class ExerciseB {
    public static void main(String[] args) {
        Flux.range(5, 3)
                .map(i -> i + 3)
                .filter(i -> i % 2 == 0)
                .buffer(3)
                .subscribe(System.out::println);
    }
}
