package hw1;

import com.epam.tat.module4.Calculator;
import hw1.CalculatorTest;
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
    public void longSubtractTest(long operand_1, long operand_2, long expected){
        long actual = calculator.sub(operand_1, operand_2);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "double-subtract-provider")
    public void doubleSubtractTest(double operand_1, double operand_2, double expected){
        double actual = calculator.sub(operand_1, operand_2);
        assertEquals(actual, expected);
    }

}
