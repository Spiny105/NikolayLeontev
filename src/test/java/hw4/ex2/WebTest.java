package hw4.ex2;

import hw3.enums.DifferentElementsPageCheckBoxes;
import hw3.enums.DifferentElementsPageDropdownItems;
import hw3.enums.DifferentElementsPageRadios;
import hw4.BaseTest;
import hw4.steps.DifferentElementsPageSteps;
import hw4.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTest extends BaseTest {

    private HomePageSteps homePageSteps;
    private DifferentElementsPageSteps differentElementsPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
        differentElementsPageSteps = new DifferentElementsPageSteps(driver);
    }

    @Test
    public void testScenario() {

        //Assert Browser title
        homePageSteps.assertPageTitle("Home Page");

        //Login
        homePageSteps.login(login, password);

        //Assert user name
        homePageSteps.assertUserName(userName);

        //Assert "Service" menu
        homePageSteps.assertServiceSubcategoryInHeader();

        //Open "Different Elements" page
        homePageSteps.goToDifferentElementsPage();

        //Assert counts of elements on "Different Elements" page
        differentElementsPageSteps.checkElementsCountOnPage();

        //Assert checkboxes
        differentElementsPageSteps.assertCheckBox(DifferentElementsPageCheckBoxes.WATER);
        differentElementsPageSteps.assertCheckBox(DifferentElementsPageCheckBoxes.WIND);

        //Assert radio
        differentElementsPageSteps.checkRadio(DifferentElementsPageRadios.SELEN);
        //Assert dropdown
        differentElementsPageSteps.assertDropDown(DifferentElementsPageDropdownItems.YELLOW);

        //Assert checkboxes again
        differentElementsPageSteps.assertCheckBox(DifferentElementsPageCheckBoxes.WATER);
        differentElementsPageSteps.assertCheckBox(DifferentElementsPageCheckBoxes.WIND);
    }
}