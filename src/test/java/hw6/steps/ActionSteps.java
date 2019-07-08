package hw6.steps;

import cucumber.api.java.en.When;
import hw6.enums.LeftSideMenu;
import hw6.enums.ServiceElementsMenu;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class ActionSteps extends BaseStep {

    @When("^I click on \"([^\"]*)\" button in Header$")
    public void clickOnButton(String buttonName) {
        homePage.getLeftSection().findElement(By.linkText(buttonName)).click();
    }

    @When("^I click on \"([^\"]*)\" button in Service dropdown$")
    public void clickOnElementInDropdownList(String item) {
        homePage.clickOnServiceSubcategoryItem(item);
    }

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void selectVipCheckbox(String name) {
        int userIndex = userTablePage.getUserNames()
                .stream()
                .map(x -> x.getText())
                .collect(Collectors.toList())
                .indexOf(name);

        userTablePage.getCheckBoxes().get(userIndex).click();

    }

    @When("^I click on dropdown in column Type for user Roman$")
    public void clickOnDropdownRoman() {
        int romanIndex = userTablePage.getUserNames().stream().map(x -> x.getText()).collect(Collectors.toList()).indexOf("Roman");
        userTablePage.getDropdowns().get(romanIndex).click();

    }

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
    public void selectCOlorFromDropdown(String color) {
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
