package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractTest extends CalculatorTest {

    @DataProvider(name = "long-subtract-provider")
    public Object[][] longDataProviderMethod() {

        return new Object[][] {
                {10L, 20L, -10L},
                {0L, 0L, 0L},
                {-20L, 20L, -40L}
        };
    }

    @DataProvider(name = "double-subtract-provider")
    public Object[][] doubleDataProviderMethod() {

        return new Object[][] {
                {10D, 20D, -10D},
                {0D, 0D, 0D},
                {-20.2D, 20.0D, -40.2D}
        };
    }

    @Test(dataProvider = "long-subtract-provider")
    public void longSubtractTest(long operand1, long operand2, long expected){
        long actual = calculator.sub(operand1, operand2);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "double-subtract-provider")
    public void doubleSubtractTest(double operand1, double operand2, double expected){
        double actual = calculator.sub(operand1, operand2);
        assertEquals(actual, expected);
    }

}
