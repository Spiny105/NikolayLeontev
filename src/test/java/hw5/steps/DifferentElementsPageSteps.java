package hw5.steps;

import hw5.DifferentElementsPage;
import hw5.enums.DifferentElementsPageCheckBoxes;
import hw5.enums.DifferentElementsPageDropdownItems;
import hw5.enums.DifferentElementsPageRadios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps {

    private DifferentElementsPage differentElementsPage;

    public DifferentElementsPageSteps(WebDriver driver){
        differentElementsPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

    public void checkElementsCountOnPage(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(differentElementsPage.getCheckBoxes().size(), 4);
        softAssert.assertEquals(differentElementsPage.getRadios().size(),4);
        softAssert.assertTrue(differentElementsPage.getButton().isDisplayed());
        softAssert.assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
        softAssert.assertTrue(differentElementsPage.getDropdown().isDisplayed());
        softAssert.assertTrue(differentElementsPage.getLeftSection().isDisplayed());
        softAssert.assertTrue(differentElementsPage.getRightSection().isDisplayed());
        softAssert.assertAll();
    }

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

    public void assertDropDown(DifferentElementsPageDropdownItems item){
        differentElementsPage.selectDropDownValue(item);
        assertTrue(differentElementsPage.getLastLogMessage().contains("Colors: value changed to " + item.getName()));
    }

}