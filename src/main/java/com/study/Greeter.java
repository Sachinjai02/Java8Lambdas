package com.study;

public class Greeter {

    private void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        //explicit instance of a Class
        Greeting helloWorldInstance = new HelloWorldGreeting();
        greeter.greet(helloWorldInstance);

        //annonymous inner class instance;
        Greeting annonymousInstance = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello Annonymous!");
            }
        };
        greeter.greet(annonymousInstance);
        //inline creation of function
        Greeting helloLambda = () -> System.out.println("hello lambda");

        greeter.greet(helloLambda);

    }

    //Lambdas are just the functions that exist in isolation
    // and do not have to belong to any class

    // Functions as values

    // For most purposes, we can say lambdas are just similar to annonymous class but
    // in reality they are not annonymous class
}
