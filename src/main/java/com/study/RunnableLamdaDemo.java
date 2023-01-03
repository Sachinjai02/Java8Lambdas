package com.study;

public class RunnableLamdaDemo {
    public static void main(String[] args) {
        Thread myThread = new Thread( () -> System.out.println("Thread is running"));
        myThread.start();
    }
}
