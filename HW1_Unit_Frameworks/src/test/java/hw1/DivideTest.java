package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DivideTest extends CalculatorTest {

    @DataProvider(name = "long-divide-provider")
    public Object[][] longDataProviderMethod() {

        return new Object[][] {
                {40L, 20L, 2L},
                {0L, 500L, 0L},
                {-20L, 20L, -1L}
        };
    }

    @DataProvider(name = "double-divide-provider")
    public Object[][] doubleDataProviderMethod() {

        return new Object[][] {
                {40D, 20D, 2D},
                {0D, 500D, 0D},
                {-31, -2, 15.5},
                {-20D, 20D, -1D},
                {20D, 0D, Double.POSITIVE_INFINITY}
        };
    }

    @Test(dataProvider = "long-divide-provider")
    public void longMultiplyTest(long operand_1, long operand_2, long expected){

        long actual = calculator.div(operand_1, operand_2);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "double-divide-provider")
    public void doubleMultiplyTest(double operand_1, double operand_2, double expected){

        double actual = calculator.div(operand_1, operand_2);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void longDivideByZeroTest() {
        calculator.div(20L, 0L);
    }
}
