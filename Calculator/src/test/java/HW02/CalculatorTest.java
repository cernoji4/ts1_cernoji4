package HW02;

import cz.cvut.fel.ts1.Calculator;
import org.junit.jupiter.api.*;

public class CalculatorTest {
    static Calculator calculator;
    private int expectedResult = 10;
    private int returnedNumber;
    private String expectedException = "number cannot be divided be zero";
    private String returnedException;

    @BeforeAll
    public static void initiation(){
        calculator = new Calculator();
    }
    @Test
    @Order(1)
    public void testAdd(){
        returnedNumber = calculator.add(3,7);
        Assertions.assertEquals(expectedResult, returnedNumber);
    }
    @Test
    @Order(2)
    public void testSubtract(){
        returnedNumber = calculator.subtract(17,7);
        Assertions.assertEquals(expectedResult, returnedNumber);
    }
    @Test
    @Order(3)
    public void testMultiply(){
        returnedNumber = calculator.multiply(2,5);
        Assertions.assertEquals(expectedResult, returnedNumber);
    }
    @Test
    @Order(4)
    public void testDivide() throws Exception{
        returnedNumber = calculator.divide(20,2);
        Assertions.assertEquals(expectedResult, returnedNumber);
    }
    @Test
    @Order(5)
    public void testDivideByZero(){
        Exception e = Assertions.assertThrows(Exception.class, () -> calculator.divide(20,0));
        returnedException = e.getMessage();
        Assertions.assertEquals(expectedException, returnedException);
    }


}
