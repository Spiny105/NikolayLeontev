package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6/ex2"},
        glue = {"classpath:hw6/ex2"},
        tags = ("@run")
)
public class RunAcceptanceEx2 extends AbstractTestNGCucumberTests{
}
