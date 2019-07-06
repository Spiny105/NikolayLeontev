package hw5;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestProvider {

    private static TestProvider instance;

    private WebDriver driver;

    public static TestProvider getInstance() {
        if (instance == null) {
            instance = new TestProvider();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}