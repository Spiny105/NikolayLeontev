package hw2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test_1 extends BaseTest {

    @Test
    public void seleniumOpenPageTest() {
        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.linkText("Metals & Colors")).click();
    }

    @Test
    public void loginTest() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@id='login-button']")).click();

        assertEquals(driver.findElement(By.id("user-name"))
                .getText(), "PITER CHAILOVSKII");
    }
}
