package hw1;

// TODO Unused import
import hw1.CalculatorTest;
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
    // TODO What is the Java Code Convention for the methods input parameters?
    public void longMultiplyTest(long operand_1, long operand_2, long expected){

        long actual = calculator.mult(operand_1, operand_2);
        assertEquals(actual, expected);

    }

    @Test(dataProvider = "double-multiply-provider")
    // TODO What is the Java Code Convention for the methods input parameters?
    public void doubleMultiplyTest(double operand_1, double operand_2, double expected){

        double actual = calculator.mult(operand_1, operand_2);
        assertEquals(actual, expected);

    }
}
