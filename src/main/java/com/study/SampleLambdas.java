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
        performConditionally(people, p -> System.out.println(p));
        //Create a method that prints all people having last name beginning with P
        performConditionally(people, p -> {
            if(p.getLastName().startsWith("P")) {
                System.out.println(p);
            }
        });
        */

        //Using Predicates
        Consumer<Person> printPerson = p -> System.out.println(p);
        // print all
        System.out.println("Printing all persons");
        performConditionally(people, p -> true, printPerson);
        //print persons whose last name begin with P
        System.out.println("\nPrinting all persons whose last name begins with P");
        performConditionally(people, p -> p.getLastName().startsWith("P"), printPerson);
    }

    private static void performConditionally(List<Person> people,
                                             Predicate<Person> personPredicate,
                                             Consumer<Person> action) {
       /* people.forEach( p -> {
            if (personPredicate.test(p)) {
                action.accept(p);
            }
        });*/
        //For each method does not guarantee the order in which elements would be processed.
        people.stream().filter(personPredicate).forEach(action);
    }

    private static void performConditionally(List<Person> people, Consumer<Person> p) {
        //The forEach order is same as that of the collections iterator
        people.forEach(p);
    }
}
