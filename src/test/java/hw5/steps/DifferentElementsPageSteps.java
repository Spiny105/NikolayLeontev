package hw5.steps;

import hw5.AllureAttachmentListener;
import hw5.DifferentElementsPage;
import hw5.enums.DifferentElementsPageCheckBoxes;
import hw5.enums.DifferentElementsPageDropdownItems;
import hw5.enums.DifferentElementsPageRadios;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

@Listeners(AllureAttachmentListener.class)
public class DifferentElementsPageSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver){
        differentElementsPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

    @Step("Chech elements count on page")
    public void checkElementsCountOnPage(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(differentElementsPage.getCheckBoxes().size(), 4, "Wrong number of checkboxes");
        softAssert.assertEquals(differentElementsPage.getRadios().size(),4, "Wrong number of radios");
        softAssert.assertTrue(differentElementsPage.getButton().isDisplayed(), "Button is't visible");
        softAssert.assertTrue(differentElementsPage.getDefaultButton().isDisplayed(), "Default button is't visible");
        softAssert.assertTrue(differentElementsPage.getDropdown().isDisplayed(), "Dropdown is't visible");
        softAssert.assertTrue(differentElementsPage.getLeftSection().isDisplayed(), "Left section is't visible");
        softAssert.assertTrue(differentElementsPage.getRightSection().isDisplayed(), "Right section is't visible");
        softAssert.assertAll();
    }

    @Step("Checkboxes functionality check")
    public void assertCheckBox(DifferentElementsPageCheckBoxes item){

        WebElement checkBox = differentElementsPage.getCheckBoxes()
                .stream()
                .filter(x->x.getText().contains(item.getName()))
                .findFirst()
                .orElse(null);

        boolean initialSelectionStatus = checkBox.findElement(By.xpath(".//input")).isSelected();
        checkBox.click();

        String expectedString = item.getName() + ": condition changed to " + !initialSelectionStatus;
        assertTrue(differentElementsPage.getLastLogMessage().contains(expectedString));

    }

    @Step("Radios functionlity check")
    public void checkRadio(DifferentElementsPageRadios item){
        WebElement radio = differentElementsPage.getRadios()
                .stream()
                .filter(x->x.getText().equals(item.getName()))
                .findFirst()
                .orElse(null);

        radio.click();

        String expectedString = "metal: value changed to " + item.getName();
        assertTrue(differentElementsPage.getLastLogMessage().contains(expectedString));
    }

    @Step("Dropdown check")
    public void assertDropDown(DifferentElementsPageDropdownItems item){
        differentElementsPage.selectDropDownValue(item);
        assertTrue(differentElementsPage.getLastLogMessage().contains("Colors: value changed to " + item.getName()));
    }

}