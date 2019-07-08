package hw6.ex2.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// TODO Code duplication from hw6.ex1.steps
// TODO AssertionSteps
public class AssertationSteps extends BaseStep {

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

}
