package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6/ex1"},
        glue = {"classpath:hw6/ex1"},
        tags = ("@run")
)
public class RunAcceptanceEx1 extends AbstractTestNGCucumberTests{
}
