package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;


import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setUpDriverPath() {
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getClassLoader().getResource("driver/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());

    }

    @BeforeMethod
    public void setUp() {
        SoftAssert softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get("https://epam.github.io/JDI");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    protected void login(String login, String password){
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    protected void checkEllementsIsDisplayed(List<String> elementsText){

        SoftAssert softAssert = new SoftAssert();
        for (String element : elementsText) {
            softAssert.assertTrue(driver.findElement(By.linkText(element)).isDisplayed(), "element" + element + "not found");
        }
        softAssert.assertAll();
    }

    protected void checkEllementsCount(String ellementClassName, int expectedCount){
        assertEquals(driver.findElements(By.className(ellementClassName)).size(), expectedCount);
    }
}
