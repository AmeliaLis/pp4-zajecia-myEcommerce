package pl.amelialis.playground;

import java.util.List;

public class Greeter {
    public void greet(String name) {
        System.out.println(String.format("Hello %s",name));
    }

    public void greetAllLadies(List<String> names) {


        for (String name : names) {
            if (name.charAt(name.length()-1) == 'a') {
                greet(name);
            }
        }
    }
}
