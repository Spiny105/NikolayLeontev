package hw6.ex1.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw6.ex1.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertationSteps extends BaseStep {

    @Then("Browser title shoul be '(.+)'")
    public void checkTitle(String title) {
        assertEquals(homePage.getPageTitle(), title);
    }

    @Then("User name should be '(.+)'")
    public void userNameShouldBe(String expectedUsername) {
        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername);
    }

    @Then("^Home page should have (\\d+) pictures$")
    public void assertImagesCount(int expectedCount) {
        int actualBenefitIconsCount = homePage.getBenefitIcons().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit icons");
    }

    @And("(\\d+) texts under them")
    public void assertTextsCountUnderImages(int expectedCount) {
        int actualBenefitIconsCount = homePage.getBenefitTexts().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit texts");
    }

    @And("two texts above")
    public void assertTextAboveImages() {
        assertTrue(homePage.getSubHeader().isDisplayed());
        assertTrue(homePage.getPageText().isDisplayed());
    }

    @Then("^Left side menu should have$")
    public void checkServiceSubcategoryElementsAreDisplayed(List<String> elements) {

        List<String> serviceElements = homePage.getServiceItems().stream().map(s -> s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (String element : elements) {
            softAssert.assertTrue(serviceElements.contains(element), "element" + element + "not found");
        }
        softAssert.assertAll();
    }

    @Then("^Differnt elements page should have (\\d+) checkboxes$")
    public void checkCheckboxesCount(int expectedCount) {
        assertEquals(differentElementsPage.getCheckBoxes().size(), expectedCount);
    }

    @Then("^Differnt elements page should have (\\d+) radios$")
    public void checkRadiosCount(int expectedCount) {
        assertEquals(differentElementsPage.getRadios().size(), expectedCount);
    }

    @Then("^Differnt elements page should have dropdown$")
    public void assertDropdown() {
        assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    @Then("^Differnt elements page should have button$")
    public void assertButton() {
        assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    @Then("^Differnt elements page should have default button$")
    public void assertDefaultButton() {
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Then("^Differnt elements page should have right section$")
    public void assertRightSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("^Differnt elements page should have left section$")
    public void assertLeftSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("^There is an correct log for selected checkboxes$")
    public void checkSelectedChechBoxes(List<String> items) {
        for (String item : items) {
            assertTrue(differentElementsPage.getLogMessages()
                    .stream()
                    .filter(x -> x.contains(item + ": condition changed to true"))
                    .findFirst().isPresent());
        }

    }

    @Then("^There is corect log for '(.+)' radio$")
    public void checkRadio(String item) {
        String expectedString = "metal: value changed to " + item;
        assertTrue(differentElementsPage.getLastLogMessage().contains(expectedString));
    }

    @Then("^There is correct log for selected '(.+)' color$")
    public void checkSelectedDropdownElement(String item) {
        String expectedString = "metal: value changed to " + item;
        assertTrue(differentElementsPage.getLastLogMessage().contains("Colors: value changed to " + item));
    }

    @Then("^There is an correct log for unselected checkboxes$")
    public void checkUnSelectedChechBoxes(List<String> items) {
        for (String item : items) {
            assertTrue(differentElementsPage.getLogMessages()
                    .stream()
                    .filter(x -> x.contains(item + ": condition changed to false"))
                    .findFirst().isPresent());
        }

    }
}
