package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:hw6"},
        glue = {"classpath:hw6"},
        tags = ("@ex2")
)
public class RunAcceptanceEx2 extends AbstractTestNGCucumberTests {
}
