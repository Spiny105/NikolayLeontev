package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest extends CalculatorTest {

    @DataProvider(name = "long-sum-provider")
    public Object[][] longDataProviderMethod() {

        return new Object[][] {
                {10L, 20L, 30L},
                {0L, 0L, 0L},
                {-20L, 20L, 0L}
        };
    }

    @DataProvider(name = "double-sum-provider")
    public Object[][] doubleDataProviderMethod() {

        return new Object[][] {
                {10.5D, 20.7D, 31.2D},
                {0D, 0D, 0D},
                {-20.3D, 20.3D, 0D}
        };
    }


    @Test(dataProvider = "long-sum-provider")
    public void longSumTest(long operand1, long operand2, long expected){
        long actual = calculator.sum(operand1, operand2);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "double-sum-provider")
    public void doubleSumTest(double operand1, double operand2, double expected){
        double actual = calculator.sum(operand1, operand2);
        assertEquals(actual, expected);
    }

}
