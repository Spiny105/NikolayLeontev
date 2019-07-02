package hw4.ex1;

import hw4.BaseTest;
import hw4.enums.LeftSideMenu;
import hw4.steps.HomePageSteps;
import hw4.steps.TableWithPagesPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTest extends BaseTest {

    private HomePageSteps homePageSteps;
    private TableWithPagesPageSteps tableWithPagesPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        tableWithPagesPageSteps = new TableWithPagesPageSteps("https://epam.github.io/JDI");
        homePageSteps = new HomePageSteps("https://epam.github.io/JDI");
    }

    @Test
    public void testScenario() {

        //Assert Browser title
        homePageSteps.assertPageTitle("Home Page");

        //Login
        homePageSteps.login(login, password);

        //Assert user name
        homePageSteps.assertUserName(userName);

        //Assert Browser title
        homePageSteps.assertPageTitle("Home Page");

        //Assert header section
        // TODO It will be better if you have static method in enum which return List of its elements
        List<LeftSideMenu> leftSideMenuItems = new ArrayList<>();
        leftSideMenuItems.add(LeftSideMenu.HOME);
        leftSideMenuItems.add(LeftSideMenu.SERVICE);
        leftSideMenuItems.add(LeftSideMenu.CONTACT_FORM);
        leftSideMenuItems.add(LeftSideMenu.METALS_AND_COLORS);
        homePageSteps.checkLeftSideElementsAreDisplayed(leftSideMenuItems);

        //Assert "Service" subcategory items
        homePageSteps.assertServiceSubcategoryInHeader();

        //Go to "Table with pages" page
        homePageSteps.goToTableWithPagesPage();

        //Assert "Show Entries" dropdown value
        tableWithPagesPageSteps.assertShowEntriesDropDownValue("5");

        //Assert that there is Right section
        tableWithPagesPageSteps.assertRightSection();

        //Assert that there is Left section
        tableWithPagesPageSteps.assertLeftSection();

        //Select new value for the entries in the dropdown list
        tableWithPagesPageSteps.selectNewValueInDropdownList("10");

        //Assert table size
        tableWithPagesPageSteps.assertTableRowsCount(10);

        //Type in “Search” text field
        String wordForSearching = "Custom";
        tableWithPagesPageSteps.typeTextInSearchField(wordForSearching);

        //Asserts records in the table
        tableWithPagesPageSteps.assertAllRecordsInTableContainsText(wordForSearching);
    }

}
