package hw1;

import com.epam.tat.module4.Calculator;
import hw1.CalculatorTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
    public void longSumTest(long operand_1, long operand_2, long expected){
        long actual = calculator.sum(operand_1, operand_2);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "double-sum-provider")
    public void doubleSumTest(double operand_1, double operand_2, double expected){
        double actual = calculator.sum(operand_1, operand_2);
        assertEquals(actual, expected);
    }

}
