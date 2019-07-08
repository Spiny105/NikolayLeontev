package hw6.ex2.hooks;

import org.openqa.selenium.WebDriver;

// TODO This class is duplicated for the TestContext from hw6.ex1.hooks
public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    static void setDriver(WebDriver driver) {
        TestContext.driver = driver;
    }
}