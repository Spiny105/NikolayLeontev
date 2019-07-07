package hw6.hooks;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    static void setDriver(WebDriver driver) {
        TestContext.driver = driver;
    }
}