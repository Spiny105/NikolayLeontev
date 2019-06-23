package hw2.ex2;

import hw2.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest extends BaseTest{

    @Test
    public void testScenario(){

        //Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //Login
        login("epam", "1234");

        //Assert user name
        assertEquals(driver.findElement(By.id("user-name")).getText(), "PITER CHAILOVSKII");

        //Assert "Service" menu
        driver.findElement(By.linkText("Service")).click();

        List<String> ellements = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Table with pages", "Different elements");
        checkEllementsIsDisplayed(ellements);

        //Open "Different Elements" page
        driver.findElement(By.linkText("Different elements")).click();

        //Assert counts of elements on "Different Elements" page
        checkEllementsCount("label-checkbox", 4);
        checkEllementsCount("label-radio", 4);
        checkEllementsCount("colors", 1);

        assertTrue(driver.findElement(By.xpath("//button[@value='Default Button']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//input[@value='Button']")).isDisplayed());

        //Assert right and left sections
        assertTrue(driver.findElement(By.id("mCSB_2")).isDisplayed(), "right section not fount");
        assertTrue(driver.findElement(By.id("mCSB_1")).isDisplayed(), "left section not found");

        //Assert chechboxes
        checkCheckBox("Water");
        checkCheckBox("Wind");

        //Assert radio
        checkRadio("Selen");

        //Assert dropdown
        checkDropDown("Yellow");

        //Assert checkboxes again
        checkCheckBox("Water");
        checkCheckBox("Wind");
    }

    private void checkCheckBox(String visibleText){
        WebElement checkBox = driver.findElement(By.xpath("//*[normalize-space(.) = '" + visibleText + "']"));
        boolean initialSelectionStatus = checkBox.isSelected();
        checkBox.click();

        if (initialSelectionStatus == false){
            assertTrue(driver.findElement(By.xpath("//li[text()[contains(.,'" + visibleText + ": condition changed to true')]]")).isDisplayed());
        }
        else{
            assertTrue(driver.findElement(By.xpath("//li[text()[contains(.,'" + visibleText + ": condition changed to false')]]")).isDisplayed());
        }
    }

    private void checkRadio(String visibleText){
        WebElement radio = driver.findElement(By.xpath("//*[normalize-space(.) = '" + visibleText + "']"));
        boolean initialSelectionStatus = radio.isSelected();
        radio.click();

        assertTrue(driver.findElement(By.xpath("//li[text()[contains(.,'metal: value changed to  " + visibleText + "')]]")).isDisplayed());
    }

    private void checkDropDown(String selectedVisibleText){
        WebElement dropDown = driver.findElement(By.xpath("//select[@class = 'uui-form-element']"));
        Select select = new Select(dropDown);
        dropDown.click();
        select.selectByVisibleText(selectedVisibleText);
        assertTrue(driver.findElement(By.xpath("//li[text()[contains(.,'Colors: value changed to " + selectedVisibleText + "')]]")).isDisplayed());
    }
}