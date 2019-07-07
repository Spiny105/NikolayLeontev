package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.DifferentElementsPageDropdownItems;
import hw4.enums.DifferentElements;
import hw6.enums.DifferentElementsPageCheckBoxes;
import hw6.enums.ServiceElementsMenu;
import hw6.enums.LeftSideMenu;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ActionSteps extends BaseStep {

    @When("I login as '([^\"]*)'/'([^\"]*)'")
    public void iLoginAs(String username, String password) {
        TestContext.getDriver().findElement(By.id("user-icon")).click();
        TestContext.getDriver().findElement(By.id("name")).sendKeys(username);
        TestContext.getDriver().findElement(By.cssSelector("#password")).sendKeys(password);
        TestContext.getDriver().findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @When("I click on Service subcategory")
    public void clickOnServiceSubcategory() {
        homePage.clickLeftSideMenu(LeftSideMenu.SERVICE);
    }

    @When("I navigate to Differnt elements page")
    public void goToDifferentElementsPage() {
        homePage.clickOnServiceSubcategoryItem(ServiceElementsMenu.DIFFERENT_ELEMENTS);
    }

    @When("^I select chechboxes$")
    public void selectCheckBoxes(List<String> items) {
        clickOnCheckboxes(items);
    }

    @When("^I select '(.+)' radio$")
    public void selectRadoi(String item) {
        differentElementsPage.getRadios()
                .stream()
                .filter(x -> x.getText().contains(item))
                .findFirst()
                .orElse(null).click();
    }

    @When("^I select '(.+)' color from dropdown$")
    public void selectCOlorFromDropdown(String color){
        differentElementsPage.selectDropDownValue(color);
    }

    @When("^I unselected checkboxes$")
    public void unSelectCheckBoxes(List<String> items) {
        clickOnCheckboxes(items);
    }

    private void clickOnCheckboxes(List<String> items) {

        for (String item : items) {
            differentElementsPage.getCheckBoxes()
                    .stream()
                    .filter(x -> x.getText().contains(item))
                    .findFirst()
                    .orElse(null).click();
        }
    }
}
