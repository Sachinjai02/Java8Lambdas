package com.study;

public class Greeter {

    private void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        new Greeter().greet(new HelloWorldGreeting());
        Greeting hello = () -> System.out.println("hello");
    }

    //Lambdas are just the functions that exist in isolation and do not have to belong to any class
    //Functions as values
}
