package com.study;

import java.util.function.Consumer;

public class ClosuresDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // b should be effectively final
        doPerform(a, i -> System.out.println(i+b));

    }

    private static void doPerform(Integer arg, Consumer<Integer> consumer) {
        consumer.accept(arg);
    }
}
