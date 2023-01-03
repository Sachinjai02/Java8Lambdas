package com.study;

import java.util.function.BiConsumer;

public class ExceptionHandlingInLambdas {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 4, 6, 8};
        int key = 0;
        BiConsumer<Integer, Integer> printDivison = (i1, i2) -> System.out.println(i1/i2);

        process(nums, key, wrapperExceptionHandlingLambda(printDivison));
    }

    private static BiConsumer<Integer, Integer> wrapperExceptionHandlingLambda(BiConsumer<Integer, Integer> consumer) {
        return ((u, v) -> {
            try {
                consumer.accept(u, v);
            }catch (Exception e) {
                System.out.println("Exception caught in wrapper lambda: " + e.getMessage());
            }
        });
    }

    private static void process(int[] nums, int key, BiConsumer<Integer, Integer> consumer) {
        for(int n : nums) {
            consumer.accept(n, key);
        }
    }
}
