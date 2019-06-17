package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;
// TODO Unused import
import org.testng.annotations.BeforeMethod;

public class CalculatorTest {

    protected Calculator calculator;

    // TODO Why do you decide use BeforeClass hook?
    @BeforeClass
    public  void  classUnderTestInit(){
        calculator = new Calculator();
    }

}
