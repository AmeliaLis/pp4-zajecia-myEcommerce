package pl.amelialis.playground;

import org.junit.jupiter.api.Test;

public class NumericRepresentationTest {

    @Test
    void lestCheckDouble(){
        double a = 0.001;
        double b = 0.003;
        double c = b - a;
        System.out.println(c);
    }

    @Test
    void lestCheckFloats(){
        double a = 0.003f;
        double b = 0.001f;
        double c = b - a;
        System.out.println(c);
    }
}
