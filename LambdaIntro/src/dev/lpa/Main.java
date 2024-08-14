package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName , String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("linus", "Van Pelt")));

        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

        people.sort(comparatorLastName);
        System.out.println(people);

        //int result = calculator((var a , var b ) -> a + b , 5,2);
    }
    public static <T> T calculator(Operation<T> function, T value1 , T value2){
        T result = function.operate(value1 , value2);
        System.out.println("Result of operation:" +result);
        return result;
    }
}