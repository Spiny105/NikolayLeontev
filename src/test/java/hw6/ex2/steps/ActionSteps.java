package hw6.ex2.steps;

import cucumber.api.java.en.When;
import hw6.enums.LeftSideMenu;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

public class ActionSteps extends BaseStep {

    @When("^I click on \"([^\"]*)\" button in Header$")
    public void clickOnButton(String buttonName){
        homePage.getLeftSection().findElement(By.linkText(buttonName)).click();
    }

    @When("^I click on \"([^\"]*)\" button in Service dropdown$")
    public void clickOnElementInDropdownList(String item){
        homePage.clickOnServiceSubcategoryItem(item);
    }

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void selectVipCheckbox(String name){
        int userIndex = userTablePage.getUserNames()
                .stream()
                .map(x->x.getText())
                .collect(Collectors.toList())
                .indexOf(name);

        userTablePage.getCheckBoxes().get(userIndex).click();

        userIndex = userTablePage.getUserNames()
                .stream()
                .map(x->x.getText())
                .collect(Collectors.toList())
                .indexOf(name);
    }

    @When("^I click on dropdown in column Type for user Roman$")
    public void clickOnDropdownRoman(){
        int romanIndex = userTablePage.getUserNames().stream().map(x->x.getText()).collect(Collectors.toList()).indexOf("Roman");
        userTablePage.getDropdowns().get(romanIndex).click();

    }

}
