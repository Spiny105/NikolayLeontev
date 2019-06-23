package hw2.ex1;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest extends BaseTest {

    @Test
    public void testScenario() {

        //Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //Login
        login("epam", "1234");

        //Assert user name
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        //Assert Browser title
        // TODO It could be extracted to separate method
        assertEquals(driver.getTitle(), "Home Page");

        //Assert header section
        // TODO elements
        // TODO Is this variable required here?
        List<String> ellements = Arrays.asList("Home", "Service", "Contact form", "Metals & Colors");
        checkEllementsIsDisplayed(ellements);

        //Assert images count
        checkEllementsCount("benefit-icon", 4);

        //Assert texts
        checkEllementsCount("benefit-txt", 4);

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
