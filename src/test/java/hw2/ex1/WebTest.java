package hw2.ex1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest extends BaseTest {

    @Test
    public void testScenario() {

        //Assert Browser title
        assertPageTitle("Home Page");

        //Login
        login("epam", "1234");

        //Assert user name
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        //Assert Browser title
        assertPageTitle("Home Page");

        //Assert header section
        checkElementsAreDisplayed(Arrays.asList("Home", "Service", "Contact form", "Metals & Colors"));

        //Assert images count
        checkElementsCount("benefit-icon", 4);

        //Assert texts
        checkElementsCount("benefit-txt", 4);

        //Assert text of the main header
        assertEquals(driver.findElement(By.name("main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver.findElement(By.name("jdi-text")).getText().contains("LOREM IPSUM"));

        //Assert that there is iframe in the page
        assertTrue(driver.findElement(By.id("iframe")).isDisplayed());

        //Switch to iframe
        driver.switchTo().frame("iframe");

        //Assert epam-logo in the frame
        assertTrue(driver.findElement(By.id("epam_logo")).isDisplayed());

        //Switch to original page
        driver.switchTo().defaultContent();

        //Assert a text and URL of the sub header
        assertEquals(driver.findElement(By.xpath("//a[@href = 'https://github.com/epam/JDI']")).getText(), "JDI GITHUB");

        //Assert that there is Left Section
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed());

        //Assert that there is Footer
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());
    }

}
