package com.study;

@FunctionalInterface
public interface Greeting {
    public abstract void perform();

    public default void another() {
        System.out.println("This is a default method. " +
                "We can have any number of default methods in a functional interface");
    }
}
