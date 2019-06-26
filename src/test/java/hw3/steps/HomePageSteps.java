package hw3.steps;

import hw3.HomePage;
import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceElementsMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public void assertPageTitle(String expectedTitle){
        assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    public void login(String userName, String login){
        homePage.login(userName, login);
    }

    public void assertUserName(String expectedUserName){
        assertEquals(homePage.getUserName(), expectedUserName);
    }

    public void checkLeftSideElementsAreDisplayed(List<String> elementsText){

        List<String> leftSideBareElements = homePage.getLeftSidebarItems().stream().map(s->s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (String element : elementsText) {
            softAssert.assertTrue(leftSideBareElements.contains(element), "element" + element + "not found");
        }
        softAssert.assertAll();
    }

    void checkServiceSubcategoryElementsAreDisplayed(List<String> elementsText){

        List<String> serviceElements = homePage.getServiceItems().stream().map(s->s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (String element : elementsText) {
            softAssert.assertTrue(serviceElements.contains(element), "element" + element + "not found");
        }
        softAssert.assertAll();
    }

    public void assertImagesCount(int expectedCount){
        int actualBenefitIconsCount = homePage.getBenefitIcons().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit icons");
    }

    public void assertTextsCountUnderImages(int expectedCount){
        int actualBenefitIconsCount = homePage.getBenefitTexts().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit texts");
    }

    public void assertTextsOfMainHeaders(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getMainHeaderText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertTrue(homePage.getPageText().contains("LOREM IPSUM"));
        softAssert.assertAll();
    }

    public void assertIFrameIsDisplayed(){
        assertTrue(homePage.getiFrame().isDisplayed());
    }

    public void assertEpamLogoInIFrame(){
        homePage.switchToIFrame();
        assertTrue(homePage.getEpamLogo().isDisplayed());
        homePage.switchToOriginalPage();
    }

    public void assertSubHeader(){
        WebElement subHeader = homePage.getSubHeader();
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void assertLeftSection(){
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    public void assertFooter(){
        assertTrue(homePage.getFooter().isDisplayed());
    }

    public void assertServiceSubcategoryInHeader(){
        homePage.clickLeftSideMenu(LeftSideMenu.SERVICE);
        checkServiceSubcategoryElementsAreDisplayed(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Table with pages", "Different elements"));

    }

    public void goToDifferentElementsPage(){
        homePage.clickOnServiceSubcategoryItem(ServiceElementsMenu.DIFFERENT_ELEMENTS);
    }
}