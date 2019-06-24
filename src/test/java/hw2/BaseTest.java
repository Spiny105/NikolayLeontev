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
        // TODO What is the difference between first and second driver set up? (fixed)
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver/chromedriver.exe")
                        .toAbsolutePath().toString());
    }

    @BeforeMethod
    public void setUp() {
        // TODO What is the purpose create instance SoftAssert  class here? (fixed)
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

    // TODO checkElementsAreDisplayed instead of checkEllementsIsDisplayed (fixed)
    protected void checkElementsAreDisplayed(List<String> elementsText){

        SoftAssert softAssert = new SoftAssert();
        for (String element : elementsText) {
            softAssert.assertTrue(driver.findElement(By.linkText(element)).isDisplayed(), "element" + element + "not found");
        }
        softAssert.assertAll();
    }

    // TODO checkElementsCount instead of checkEllementsCount (fixed)
    // TODO elementsClassName instead of ellementClassName (fixed)
    protected void checkElementsCount(String elementsClassName, int expectedCount){
        assertEquals(driver.findElements(By.className(elementsClassName)).size(), expectedCount);
    }

    protected void clickOnElement(String linkText){driver.findElement(By.linkText(linkText)).click();}

    protected void assertPageTitle(String expectedTitle){
        assertEquals(driver.getTitle(), expectedTitle);
    }
}
