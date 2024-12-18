package com.sketysoft.assignment;

import java.util.*;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        System.out.println("\t\tLambdas and Method References");
        LambdasAndMethodReferences.divider();
        LambdasAndMethodReferences.title("Method References");
        LambdasAndMethodReferences.staticMR();
        LambdasAndMethodReferences.divider();
        LambdasAndMethodReferences.title("Bound Method References");
        LambdasAndMethodReferences.boundMR();
        LambdasAndMethodReferences.divider();
        LambdasAndMethodReferences.title("Unbound Method References");
        LambdasAndMethodReferences.unboundMR();
        LambdasAndMethodReferences.divider();
        LambdasAndMethodReferences.title("Constructor Method References");
        LambdasAndMethodReferences.constructorMR();
        LambdasAndMethodReferences.divider();
    }// end of main method

    private static void title(String title) {
        char divider = '¯';
        System.out.println(title);
        for(int i = 0; i < title.length() + 1; i++) {
            System.out.print(divider);
        }
        System.out.println();
    }// end of divider method

    private static void divider() {
        System.out.println("------------------------------------------------");
    }// end of divider method

    public static void staticMR() {
        // a.
        List<Integer> numbers = Arrays.asList(1, 2, 7, 4, 5);
        List<Integer> numbersCopy = Arrays.asList(1, 2, 7, 4, 5);// copy of numbers list for comparison
        // b.
        Consumer<List<Integer>> sortNumbersLambda = s -> Collections.sort(numbers);
        // c.
        sortNumbersLambda.accept(numbers);// invoke the sortNumbersLambda
        // d.
        System.out.println("Original list: " + numbersCopy);
        System.out.println("Sorted list: " + numbers);
        // e.
        Consumer<List<Integer>> sortNumbersMethodReference = Collections::sort;
        // f.i.
            // sort(List) is called
        // f.ii.
            // Java knows which version to call by the number of arguments passed to the method
        // g.
        sortNumbersMethodReference.accept(numbers); // invoke the sortNumbersMethodReference
        // h.
        System.out.println("Original list: " + numbersCopy);
        System.out.println("Sorted list: " + numbers);
    }// end of staticMR method

    public static void boundMR() {
        // a.
        String name = "Mr. Joe Bloggs";
        // b.
        Predicate<String> startsWithMrLambda = s -> s.startsWith("Mr.");
        // c.
        System.out.println("Does " + name + " starts with: \"Mr.\" : " + startsWithMrLambda.test("Mr."));
        // d.
        System.out.println("Does " + name + " starts with: \"Ms.\" : " + startsWithMrLambda.test("Ms."));
        // e.
        Predicate<String> startsWithMrMethodReference = name::startsWith;
        // f.
        System.out.println("Does " + name + " starts with: \"Mr.\" : " + startsWithMrMethodReference.test("Mr."));
        System.out.println("Does " + name + " starts with: \"Ms.\" : " + startsWithMrMethodReference.test("Ms."));

    }// end of boundMR method

    public static void unboundMR() {
        // a.
        Predicate<String> isEmptyLambda = s -> s.isEmpty();
        // b.
        System.out.println("Is \"\" empty? : " + isEmptyLambda.test(""));
        // c.
        System.out.println("Is \"xyz\" empty? : " + isEmptyLambda.test("xyz"));
        // d.
        Predicate<String> isEmptyMethodReference = String::isEmpty;
        // e.
        System.out.println("Is \"\" empty? : " + isEmptyMethodReference.test(""));
        System.out.println("Is \"xyz\" empty? : " + isEmptyMethodReference.test("xyz"));
        // f.
        BiPredicate<String, String> startsWithLambda = (s, prefix) -> s.startsWith(prefix);
        System.out.println("Does \"Mr. Joe Bloggs\" starts with: \"Mr.\" : " + startsWithLambda.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("Does \"Mr. Joe Bloggs\" starts with: \"Ms.\" : " + startsWithLambda.test("Mr. Joe Bloggs", "Ms."));
        // g.
        BiPredicate<String, String> startsWithMethodReference = String::startsWith;
        // h.
        System.out.println("Does \"Mr. Joe Bloggs\" starts with: \"Mr.\" : " + startsWithMethodReference.test("Mr. Joe Bloggs", "Mr."));
        System.out.println("Does \"Mr. Joe Bloggs\" starts with: \"Ms.\" : " + startsWithMethodReference.test("Mr. Joe Bloggs", "Ms."));
    }// end of unboundMR method

    public static void constructorMR() {
        // a.
        Supplier<List<String>> listSupplierLambda = () -> new ArrayList<>();// lambda expression to create a new ArrayList
        // b.
        List<String> list = listSupplierLambda.get();// invoke the listSupplierLambda to create a new ArrayList
        // c.
        list.add("Supplier Lambda");// add a string to the list
        // d.
        System.out.println("List created using Supplier Lambda: " + list);// print the list
        // e.
        Supplier<List<String>> listSupplierMethodReference = ArrayList::new;// method reference to create a new ArrayList
        list = listSupplierMethodReference.get();// invoke the listSupplierMethodReference to create a new ArrayList
        list.add("Supplier Method Reference");// add a string to the list
        System.out.println("List created using Supplier Method Reference: " + list);// print the list
        // f.
        Function<Integer,List<String>> listFunctionLambda = i -> new ArrayList<>(i);// lambda expression to create a new ArrayList
        list = listFunctionLambda.apply(10);// invoke the listFunctionLambda to create a new ArrayList with a capacity of 10
        list.add("Function Lambda");// add a string to the list
        System.out.println("List created using Function Lambda: " + list);// print the list
        // g.
        Function<Integer,List<String>> listFunctionMethodReference = ArrayList::new;// method reference to create a new ArrayList
        list = listFunctionMethodReference.apply(10);// invoke the listFunctionMethodReference to create a new ArrayList with a capacity of 10
        list.add("Function Method Reference");// add a string to the list
        System.out.println("List created using Function Method Reference: " + list);// print the list
    }// end of constructorMR method
}
