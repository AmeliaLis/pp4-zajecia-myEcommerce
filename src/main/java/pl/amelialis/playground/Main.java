package pl.amelialis.playground;

import pl.amelialis.playground.Greeter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //alt + enters - skrót
        List<String> names = Arrays.asList("Jakub","Michał","Maria","Iwona");
        Greeter greeter = new Greeter();
        greeter.greet("Jan"); //-> hello kuba
        greeter.greetAllLadies(names);

        List<String> ladies = new ArrayList<>();
        for (String name : names) {
            if (name.endsWith("a")) {
                ladies.add(name);
            }
        }

        for (String ladyName : ladies) {
            greeter.greet(ladyName);
        }

        names.stream()
                .filter(name -> name.endsWith("a"))
                .filter(name -> name.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(greeter::greet);
    }
}