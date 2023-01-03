package com.study;

import java.util.function.BiConsumer;

public class ExceptionHandlingInLambdas {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 4, 6, 8};
        int key = 0;

        process(nums, key, (i1, i2) -> {
            try {
                System.out.println(i1/i2);
            }catch (Exception e) {
                System.out.println("Exception occurred in division of 2 nums : " + i1 + " , " + i2) ;
            }
        });

    }

    private static void process(int[] nums, int key, BiConsumer<Integer, Integer> consumer) {
        for(int n : nums) {
            consumer.accept(n, key);
        }
    }
}
