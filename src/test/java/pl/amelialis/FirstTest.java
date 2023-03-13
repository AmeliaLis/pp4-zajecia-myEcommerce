package pl.amelialis;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class FirstTest {

    @Test
    void testIt() {
        assert true == true;
    }

    @Test
    void testIt2(){
        String myName = "Amelia";
        String output = String.format("Hello %s", myName);

        assert output.equals("Hello Amelia");
    }

    @Test
    void baseSchema(){
        //Arrange  //Given   //Input
        //Act      //When    //Interaction
        //Assert   //Then    //Output
    }
}
