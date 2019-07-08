package hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// TODO This class is duplicated for the CucumberHooks from hw6.ex1.hooks (fixed)
public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        TestContext.setDriver(driver);
    }

    @After
    public void closeDriver() {
        TestContext.getDriver().close();
    }


}