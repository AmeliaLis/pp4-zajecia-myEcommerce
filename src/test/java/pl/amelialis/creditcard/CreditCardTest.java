package pl.amelialis.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit(){
        //Arrange
        CreditCard card = new CreditCard("1234-5678");

        //Act
        card.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }

    @Test
    void itAllowsToAssignCreditLimits(){
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));

        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
    }

    @Test
    void itCantAssignLimitBelow100(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");
        CreditCard card3 = new CreditCard("1234-5678");

        assertThrows(CreditBelowThresholdException.class,
                () -> card1.assignCredit(BigDecimal.valueOf(10)));

        assertThrows(CreditBelowThresholdException.class,
                () -> card2.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(() -> card2.assignCredit(BigDecimal.valueOf(100)));
    }

    @Test
    void itCantAssignLimitBelow100V1(){
        CreditCard card = new CreditCard("1234-5678");

        try {
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        } catch (CreditBelowThresholdException e) {
            assertTrue(true);
        }
    }

    @Test
    void itCantAssignLimitTwice(){
        CreditCard card = new CreditCard("1234-1234");

        assertDoesNotThrow(() -> card.assignCredit(BigDecimal.valueOf(100)));
        assertThrows(ReassignCreditExceptions.class, () -> card.assignCredit(BigDecimal.valueOf(110)));
    }

    @Test
    void itAllowsToWithdraw(){
        CreditCard card = new CreditCard("1234-5678");
        card.assignCredit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(900),card.getBalance());
    }

}
