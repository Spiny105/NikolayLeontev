package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplyTest extends CalculatorTest {

    @DataProvider(name = "double-multiply-provider")
    public Object[][] doubleDataProviderMethod() {

        return new Object[][] {
                {10.25, 2.0, 20.50},
                {0, 0, 0},
                {-20, 20, -400}
        };
    }

    @DataProvider(name = "long-multiply-provider")
    public Object[][] longDataProviderMethod() {

        return new Object[][] {
                {10L, 20L, 200L},
                {0L, 0L, 0L},
                {-20L, 20L, -400L}
        };
    }

    @Test(dataProvider = "long-multiply-provider")
    public void longMultiplyTest(long operand1, long operand2, long expected){

        long actual = calculator.mult(operand1, operand2);
        assertEquals(actual, expected);

    }

    @Test(dataProvider = "double-multiply-provider")
    public void doubleMultiplyTest(double operand1, double operand2, double expected){

        double actual = calculator.mult(operand1, operand2);
        assertEquals(actual, expected);

    }
}
