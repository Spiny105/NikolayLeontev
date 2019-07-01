package hw4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.HomePage;
import hw4.enums.LeftSideMenu;
import hw4.enums.ServiceElementsMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(String url) {
        homePage = Selenide.open(url, HomePage.class);
    }

    public void assertPageTitle(String expectedTitle) {
        assert Selenide.title().contains(expectedTitle);
    }

    public void login(String userName, String login) {
        homePage.login(userName, login);
    }

    public void assertUserName(String expectedUserName) {
        homePage.getUserName().shouldHave(Condition.text(expectedUserName));
    }

    public void checkLeftSideElementsAreDisplayed(List<LeftSideMenu> elementsText) {

        List<String> leftSideBareElements = homePage.getLeftSidebarItems().stream().map(s -> s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (LeftSideMenu element : elementsText) {
            softAssert.assertTrue(leftSideBareElements.contains(element.getName()), "element" + element.getName() + "not found");
        }
        softAssert.assertAll();
    }

    void checkServiceSubcategoryElementsAreDisplayed(List<ServiceElementsMenu> elementsText) {

        List<String> serviceElements = homePage.getServiceItems().stream().map(s -> s.getText()).collect(Collectors.toList());

        SoftAssert softAssert = new SoftAssert();
        for (ServiceElementsMenu element : elementsText) {
            softAssert.assertTrue(serviceElements.contains(element.getName()));
        }
        softAssert.assertAll();
    }

    public void assertImagesCount(int expectedCount) {
        int actualBenefitIconsCount = homePage.getBenefitIcons().size();
        assertEquals(actualBenefitIconsCount, expectedCount, "Wrong number of benefit icons");
    }

    public void assertTextsCountUnderImages(int expectedCount) {
        homePage.getBenefitTexts().shouldHaveSize(expectedCount);
    }

    public void assertTextsOfMainHeaders() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(homePage.getMainHeaderText(), "EPAM FRAMEWORK WISHES…");
        softAssert.assertTrue(homePage.getPageText().contains("LOREM IPSUM"));
        softAssert.assertAll();
    }

    public void assertIFrameIsDisplayed() {
        homePage.getiFrame().shouldBe(Condition.visible);
    }

    public void assertEpamLogoInIFrame() {
        homePage.switchToIFrame();
        homePage.getEpamLogo().shouldBe(Condition.visible);
        homePage.switchToOriginalPage();
    }

    public void assertSubHeader() {
        homePage.getSubHeader().shouldBe(Condition.visible);
        homePage.getSubHeader().shouldHave(Condition.text("JDI GITHUB"));
    }

    public void assertLeftSection() {
        homePage.getLeftSection().shouldBe(Condition.visible);
    }

    public void assertFooter() {
        homePage.getFooter().shouldBe(Condition.visible);
    }

    public void assertServiceSubcategoryInHeader() {
        homePage.clickLeftSideMenu(LeftSideMenu.SERVICE);
        List<ServiceElementsMenu> serviceSubmenuItems = new ArrayList<>();
        serviceSubmenuItems.add(ServiceElementsMenu.SUPPORT);
        serviceSubmenuItems.add(ServiceElementsMenu.DATES);
        serviceSubmenuItems.add(ServiceElementsMenu.COMPLEX_TABLE);
        serviceSubmenuItems.add(ServiceElementsMenu.SIMPLE_TABLE);
        serviceSubmenuItems.add(ServiceElementsMenu.TABLE_WITH_PAGES);
        serviceSubmenuItems.add(ServiceElementsMenu.DIFFERENT_ELEMENTS);
        checkServiceSubcategoryElementsAreDisplayed(serviceSubmenuItems);

    }

    public void goToDifferentElementsPage() {
        homePage.clickOnServiceSubcategoryItem(ServiceElementsMenu.DIFFERENT_ELEMENTS);
    }

    public void goToTableWithPagesPage() {
        homePage.clickOnServiceSubcategoryItem(ServiceElementsMenu.TABLE_WITH_PAGES);
    }

    public void goToMetalAndColorsPage() {
        homePage.clickLeftSideMenu(LeftSideMenu.METALS_AND_COLORS);
    }
}