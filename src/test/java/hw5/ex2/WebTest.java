package hw5.ex2;

import hw5.AllureAttachmentListener;
import hw5.enums.DifferentElementsPageCheckBoxes;
import hw5.enums.DifferentElementsPageDropdownItems;
import hw5.enums.DifferentElementsPageRadios;
import hw5.BaseTest;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.HomePageSteps;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureAttachmentListener.class)
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

    @Step("Test of homepage and different elements pages")
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