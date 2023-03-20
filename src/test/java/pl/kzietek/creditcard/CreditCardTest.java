package pl.kzietek.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class CreditCardTest {

    @Test
    void itAllowsToAssignCreditLimit() {
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assignCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getBalance());
    }
    @Test
    void itAllowsToAssignDifferentCreditLimit() {
        //Arrange
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5678");
        //Act
        card1.assignCredit(BigDecimal.valueOf(1000));
        card2.assignCredit(BigDecimal.valueOf(1100));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card1.getBalance());
        assertEquals(BigDecimal.valueOf(1100), card2.getBalance());
    }

    @Test
    void itCantAssignLimitBelowCertainThreshold() {
        CreditCard card = new CreditCard("1234-5678");


        try {
            card.assignCredit(BigDecimal.valueOf(10));
            fail("Should throw exception");
        } catch (CreditLimitBelowThresholdException e) {
            assertTrue(true);
        }

        assertThrows(CreditLimitBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(10)));

        assertThrows(CreditLimitBelowThresholdException.class,
                () -> card.assignCredit(BigDecimal.valueOf(99)));

        assertDoesNotThrow(
                () -> card.assignCredit(BigDecimal.valueOf(100)));

    }

    @Test
    void itDenyToAssignLimitTwice() {
        CreditCard card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));

        assertThrows(
                CreditAssignedTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1100))
        );
    }

    @Test
    void itAllowWithdraw() {
        //Arrange
        CreditCard card = new CreditCard("1234-4567");
        card.assignCredit(BigDecimal.valueOf(1000));
        //Act
        card.withdraw(BigDecimal.valueOf(100));
        //Assert
        assertEquals(BigDecimal.valueOf(900), card.getBalance());
    }
}
