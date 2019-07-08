package hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Code duplication from hw6.ex1.steps (fixed)
// TODO AssertionSteps (fixed)
public class AssertionSteps extends BaseStep {

    @Then("^\"([^\"]*)\" page is opened$")
    public void checkPageHeader(String header) {
        String title = userTablePage.getPageTitle();
        assertEquals(title, header);
    }

    @Then("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkDropdownsCountOnPage(int expectedCount) {
        assertEquals(userTablePage.getDropdowns().size(), expectedCount);
    }

    @Then("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkUserNamesCount(int expectedCount) {

        assertEquals(userTablePage.getUserNames().size(), expectedCount);
    }

    @Then("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkDescriptionImages(int expectedCount) {
        assertEquals(userTablePage.getDescriptionImages().size(), expectedCount);
    }

    @Then("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkDescriptionTextsUnderImages(int expectedCount) {
        assertEquals(userTablePage.getDescriptionTexts().size(), expectedCount);
    }

    @Then("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkCheckboxesCount(int expectedCount) {
        assertEquals(userTablePage.getCheckBoxes().size(), expectedCount);
    }


    @Then("^User table contains following values:$")
    public void checkValuesInTable(DataTable dataTable) {
        List<Map<String, String>> expectedTableData = dataTable.asMaps(String.class, String.class);

        String actualNumber = "";
        String expectedNumber = "";

        String actualName = "";
        String expectedName = "";

        String actualDescriptionText;

        for (int i = 0; i < expectedTableData.size(); i++) {

            actualNumber = userTablePage.getNumbersCollumn().get(i).getText();
            expectedNumber = expectedTableData.get(i).get("Number");
            assertEquals(actualNumber, expectedNumber);

            actualName = userTablePage.getUserNames().get(i).getText();
            expectedName = expectedTableData.get(i).get("User");
            assertEquals(actualName, expectedName);

            actualDescriptionText = userTablePage.getDescriptionTextsCollumn().get(i).getText();

            switch (expectedTableData.get(i).get("Description")) {
                case "Lorem ipsum":
                    assertTrue(!actualDescriptionText.isEmpty());
                    break;

                case "Lorem ipsum some description":
                    assertTrue(actualDescriptionText.contains("some description"));
                    break;
            }
        }
    }

    @Then("^(\\d+) log row has \"([^\"]*)\" text in log section$")
    public void chechLog(int record, String value) {
        assertTrue(userTablePage.getLogMessages().get(record - 1).contains(value));
    }

    @Then("^droplist contains values$")
    public void chechDropdownValues(List<String> expectedItems) {

        int romanIndex = userTablePage.getUserNames().stream().map(x -> x.getText()).collect(Collectors.toList()).indexOf("Roman");

        List<String> itemsInList = userTablePage.getDropdownList(romanIndex).stream()
                .map(x -> x.getText()).collect(Collectors.toList());

        for (int i = 1; i < expectedItems.size(); i++) {
            assertTrue(itemsInList.contains(expectedItems.get(i)));
        }
    }

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

    @And("Home page should hame (\\d+) texts under pictures")
    public void assertTextsCountUnderImages(int expectedCount) {
        int actualBenefitIconsCount = homePage.getBenefitTexts().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit texts");
    }

    @And("Home page should hame two texts above pictures")
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

    @Then("Different elements page should have (\\d+) checkboxes")
    public void chechCheckboxes(int expectedCount){
        assertEquals(differentElementsPage.getCheckBoxes().size(), expectedCount);
    }

    @Then("^Different elements page should have (\\d+) radios$")
    public void checkRadiosCount(int expectedCount) {
        assertEquals(differentElementsPage.getRadios().size(), expectedCount);
    }

    @Then("^Different elements page should have dropdown$")
    public void assertDropdown() {
        assertTrue(differentElementsPage.getDropdown().isDisplayed());
    }

    @Then("^Different elements page should have button$")
    public void assertButton() {
        assertTrue(differentElementsPage.getButton().isDisplayed());
    }

    @Then("^Different elements page should have default button$")
    public void assertDefaultButton() {
        assertTrue(differentElementsPage.getDefaultButton().isDisplayed());
    }

    @Then("^Different elements page should have right section$")
    public void assertRightSection() {
        assertTrue(differentElementsPage.getRightSection().isDisplayed());
    }

    @Then("^Different elements page should have left section$")
    public void assertLeftSection() {
        assertTrue(differentElementsPage.getLeftSection().isDisplayed());
    }

    @Then("^Log rows are displayed, checkbox name and its status is corresponding to selected$")
    public void checkSelectedChechBoxes(List<String> items) {
        for (String item : items) {
            assertTrue(differentElementsPage.getLogMessages()
                    .stream()
                    .filter(x -> x.contains(item + ": condition changed to true"))
                    .findFirst().isPresent());
        }

    }

    @Then("^'(.+)' log row is displayed, radiobutton name and its status is corresponding to selected$")
    public void checkRadio(String item) {
        String expectedString = "metal: value changed to " + item;
        assertTrue(differentElementsPage.getLastLogMessage().contains(expectedString));
    }

    @Then("Log row is displayed, dropdown name and selected value '(.+)' is corresponding to selected")
    public void checkSelectedDropdownElement(String item) {
        // TODO Why this variable is here? (fixed)
        assertTrue(differentElementsPage.getLastLogMessage().contains("Colors: value changed to " + item));
    }

    @Then("^Log rows are displayed, checkbox name and its status is corresponding to unselected$")
    public void checkUnSelectedChechBoxes(List<String> items) {
        for (String item : items) {
            assertTrue(differentElementsPage.getLogMessages()
                    .stream()
                    .filter(x -> x.contains(item + ": condition changed to false"))
                    .findFirst().isPresent());
        }

    }

}
