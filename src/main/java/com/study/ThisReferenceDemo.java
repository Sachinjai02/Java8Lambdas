package com.study;

import java.util.function.Consumer;

public class ThisReferenceDemo {

    public void doProcess(Integer n , Consumer<Integer> consumer) {
        consumer.accept(n);
    }

    public static void main(String[] args) {
        ThisReferenceDemo thisReferenceDemo = new ThisReferenceDemo();
        thisReferenceDemo.doProcess(10, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Input is " + integer);
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "Annonymous inner class";
            }
        });

        thisReferenceDemo.doProcess(10, i-> {
            System.out.println("Input is " + i);
            //System.out.println(this); since lambda is not an object of any class; this is not allowed
            //as this would refer to the reference outside of the lambda fn
            // but that won't be allowed as main is static
        });

        thisReferenceDemo.execute();
    }

    private void execute() {
        doProcess(10, i-> {
            System.out.println("Input is " + i);
            System.out.println(this);
        });
    }

    @Override
    public String toString() {
        return "ThisReferenceDemo class";
    }
}
