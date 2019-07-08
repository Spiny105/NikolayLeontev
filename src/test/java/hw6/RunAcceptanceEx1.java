package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"},
        tags = ("@ex1")
)
public class RunAcceptanceEx1 extends AbstractTestNGCucumberTests {
}
