package hw3.ex1;

import hw3.BaseTest;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

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
        homePageSteps.login("epam", "1234");

        //Assert user name
        homePageSteps.assertUserName("PITER CHAILOVSKII");

        //Assert Browser title
        homePageSteps.assertPageTitle("Home Page");

        //Assert header section
        homePageSteps.checkLeftSideElementsAreDisplayed(Arrays.asList("Home", "Service", "Contact form", "Metals & Colors"));

        //Assert images count
        homePageSteps.assertImagesCount(4);

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
