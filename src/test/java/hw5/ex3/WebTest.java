package hw5.ex3;

import hw5.BaseTest;
import hw5.enums.LeftSideMenu;
import hw5.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTest extends BaseTest {

    private HomePageSteps homePageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps(driver);
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
        List<LeftSideMenu> leftSideMenuItems = new ArrayList<>();
        leftSideMenuItems.add(LeftSideMenu.HOME);
        leftSideMenuItems.add(LeftSideMenu.SERVICE);
        leftSideMenuItems.add(LeftSideMenu.CONTACT_FORM);
        leftSideMenuItems.add(LeftSideMenu.METALS_AND_COLORS);
        homePageSteps.checkLeftSideElementsAreDisplayed(leftSideMenuItems);

        //Assert images count
        homePageSteps.assertImagesCount(10);

        //Assert texts
        homePageSteps.assertTextsCountUnderImages(4);

        //Assert text of the main header
        homePageSteps.assertTextsOfMainHeaders();

        //Assert that there is iframe in the page
        homePageSteps.assertIFrameIsDisplayed();

        //Assert epam-logo in the frame
        homePageSteps.assertEpamLogoInIFrame();

        //Assert a text and URL of the sub header
        homePageSteps.assertSubHeader();

        //Assert that there is Left Section
        homePageSteps.assertLeftSection();

        //Assert that there is Footer
        homePageSteps.assertFooter();
    }

}
