package com.study;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SampleLambdas {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                    new Person("Sachin", "Joi", 35),
                new Person("Xuxu", "Poi", 34),
                new Person("Lulu", "Poi", 3),
                new Person("Pulu", "Toi", 10)
        );

        //sort list by last name
        people.sort( (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        /*

        //create a method that prints all elements in the list
        printList(people, p -> System.out.println(p));
        //Create a method that prints all people having last name beginning with P
        printList(people, p -> {
            if(p.getLastName().startsWith("P")) {
                System.out.println(p);
            }
        });
        */

        //Using Predicates
        // print all
        System.out.println("Printing all persons");
        printList(people, p -> true);
        //print persons whose last name begin with P
        System.out.println("\nPrinting all persons whose last name begins with P");
        printList(people, (Predicate<Person>)  p -> p.getLastName().startsWith("P"));
    }

    private static void printList(List<Person> people, Predicate<Person> personPredicate) {
        people.forEach( p -> {
            if (personPredicate.test(p)) {
                System.out.println(p);
            }
        });
    }

    private static void printList(List<Person> people, Consumer<Person> p) {
        people.forEach(p);
    }
}
