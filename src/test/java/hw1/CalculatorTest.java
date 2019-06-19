package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public class CalculatorTest {

    protected Calculator calculator;

    @BeforeMethod
    public  void  classUnderTestInit(){
        calculator = new Calculator();
    }

}
