package com.study;

import java.util.function.Consumer;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        Thread t = new Thread( () -> perform());
        t.start();
        //or
        t = new Thread(MethodReferenceDemo::perform);

        t.start();

        takeAction(10, i -> System.out.println(i));
        //OR
        takeAction(10, System.out::println);

        MethodReferenceDemo thisReferenceDemo = new MethodReferenceDemo();
        Thread t2 = new Thread( thisReferenceDemo::instancePerform);
        t2.start();
    }

    private static void takeAction(Integer inp, Consumer<Integer> action) {
        action.accept(inp);
    }

    public static void perform() {
        System.out.println("Hey there!");
    }

    public void instancePerform() {
        System.out.println("Hey there!" + this);
    }
}
