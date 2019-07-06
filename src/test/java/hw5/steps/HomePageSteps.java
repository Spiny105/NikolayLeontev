package hw5.steps;

import hw5.AllureAttachmentListener;
import hw5.HomePage;
import hw5.enums.LeftSideMenu;
import hw5.enums.ServiceElementsMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(AllureAttachmentListener.class)
public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Step("Chech page title {0}")
    public void assertPageTitle(String expectedTitle){
        assertEquals(homePage.getPageTitle(), expectedTitle);
    }

    @Step("Login as user {0} with login {1}")
    public void login(String userName, String login){
        homePage.login(userName, login);
    }

    @Step("Check user name {0}")
    public void assertUserName(String expectedUserName){
        assertEquals(homePage.getUserName(), expectedUserName);
    }

    @Step("Assert left side is visible")
    public void checkLeftSideElementsAreDisplayed(List<LeftSideMenu> elementsText){

        List<String> leftSideBareElements = homePage.getLeftSidebarItems().stream().map(s->s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (LeftSideMenu element : elementsText) {
            softAssert.assertTrue(leftSideBareElements.contains(element.getName()), "element" + element.getName() + "not found");
        }
        softAssert.assertAll();
    }

    @Step("Check service subcategory list")
    void checkServiceSubcategoryElementsAreDisplayed(List<String> elementsText){

        List<String> serviceElements = homePage.getServiceItems().stream().map(s->s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (String element : elementsText) {
            softAssert.assertTrue(serviceElements.contains(element), "element" + element + "not found");
        }
        softAssert.assertAll();
    }

    @Step("Assert imege count")
    public void assertImagesCount(int expectedCount){
        int actualBenefitIconsCount = homePage.getBenefitIcons().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit icons");
    }

    @Step("Assert texts count under the pages")
    public void assertTextsCountUnderImages(int expectedCount){
        int actualBenefitIconsCount = homePage.getBenefitTexts().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit texts");
    }

    @Step("Assert text of main header")
    public void assertTextsOfMainHeaders(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getMainHeaderText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertTrue(homePage.getPageText().contains("LOREM IPSUM"));
        softAssert.assertAll();
    }

    @Step("Assert frame is displayed")
    public void assertIFrameIsDisplayed(){
        assertTrue(homePage.getiFrame().isDisplayed());
    }

    @Step("Assert epam logo in frame")
    public void assertEpamLogoInIFrame(){
        homePage.switchToIFrame();
        assertTrue(homePage.getEpamLogo().isDisplayed());
        homePage.switchToOriginalPage();
    }

    @Step("Assert subheader")
    public void assertSubHeader(){
        WebElement subHeader = homePage.getSubHeader();
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    @Step("Assert left section is visible")
    public void assertLeftSection(){
        assertTrue(homePage.getLeftSection().isDisplayed());
    }

    @Step("Assert footer is visible")
    public void assertFooter(){
        assertTrue(homePage.getFooter().isDisplayed());
    }

    @Step("Assert service subcategory elements")
    public void assertServiceSubcategoryInHeader(){
        homePage.clickLeftSideMenu(LeftSideMenu.SERVICE);
        checkServiceSubcategoryElementsAreDisplayed(Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Table with pages", "Different elements"));

    }

    @Step("Navigate to \"Different elements\" page")
    public void goToDifferentElementsPage(){
        homePage.clickOnServiceSubcategoryItem(ServiceElementsMenu.DIFFERENT_ELEMENTS);
    }
}