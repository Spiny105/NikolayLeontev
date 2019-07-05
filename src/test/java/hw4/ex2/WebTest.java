package hw4.ex2;

import hw4.BaseTest;
import hw4.enums.Colors;
import hw4.enums.DifferentElements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import hw4.steps.HomePageSteps;
import hw4.steps.MetalAndColorPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import hw4.builder.MetalAndColorPageTestData;

import java.util.Arrays;
import java.util.List;

public class WebTest extends BaseTest {

    private HomePageSteps homePageSteps;
    private MetalAndColorPageSteps metalAndColorPageSteps;

    @DataProvider(name = "test-data")
    public static Object[][] dataProviderMethod() {

        return new Object[][]{

                {MetalAndColorPageTestData.builder()
                        .firstDigitInSummary(null)
                        .secondDigitInSummary(null)
                        .differentElementsToCheck(Arrays.asList(DifferentElements.EARTH))
                        .colorToSelect(Colors.YELLOW)
                        .metalToSelect(Metals.GOLD)
                        .vegetablesToCheck(null)
                        .build()},

                {MetalAndColorPageTestData.builder()
                        .firstDigitInSummary(3)
                        .secondDigitInSummary(8)
                        .differentElementsToCheck(null)
                        .colorToSelect(null)
                        .metalToSelect(null)
                        .vegetablesToCheck(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO))
                        .build()},

                {MetalAndColorPageTestData.builder()
                        .firstDigitInSummary(3)
                        .secondDigitInSummary(2)
                        .differentElementsToCheck(Arrays.asList(DifferentElements.WIND, DifferentElements.FIRE, DifferentElements.WATER))
                        .colorToSelect(null)
                        .metalToSelect(Metals.BRONZE)
                        .vegetablesToCheck(Arrays.asList(Vegetables.ONION))
                        .build()},

                {MetalAndColorPageTestData.builder()
                        .firstDigitInSummary(5)
                        .secondDigitInSummary(6)
                        .differentElementsToCheck(Arrays.asList(DifferentElements.WATER))
                        .colorToSelect(Colors.GREEN)
                        .metalToSelect(Metals.SELEN)
                        .vegetablesToCheck(Arrays.asList(Vegetables.ONION, Vegetables.TOMATO, Vegetables.CUCUMBER, Vegetables.VEGETABLES))
                        .build()},

                {MetalAndColorPageTestData.builder()
                        .firstDigitInSummary(null)
                        .secondDigitInSummary(null)
                        .differentElementsToCheck(null)
                        .colorToSelect(null)
                        .metalToSelect(null)
                        .vegetablesToCheck(null)
                        .build()},
        };
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps("https://epam.github.io/JDI");
        metalAndColorPageSteps = new MetalAndColorPageSteps("https://epam.github.io/JDI");
    }

    @Test(dataProvider = "test-data")
    public void testScenario(MetalAndColorPageTestData testData) {

        //Assert Browser title
        homePageSteps.assertPageTitle("Home Page");

        //Login
        homePageSteps.login(login, password);

        //Assert user name
        homePageSteps.assertUserName(userName);

        //Open "Different Elements" page
        homePageSteps.goToMetalAndColorsPage();

        //Fill form
        if (testData.getVegetablesToCheck() != null) {
            metalAndColorPageSteps.selectVegetables(testData.getVegetablesToCheck());
        }

        if (testData.getMetalToSelect() != null) {
            metalAndColorPageSteps.selectMetal(testData.getMetalToSelect());
        }

        if (testData.getColorToSelect() != null) {
            metalAndColorPageSteps.selectColor(testData.getColorToSelect());
        }

        if (testData.getDifferentElementsToCheck() != null) {
            metalAndColorPageSteps.selectDifferentElements(testData.getDifferentElementsToCheck());
        }

        if ((testData.getFirstDigitInSummary() != null) && (testData.getSecondDigitInSummary() != null)) {
            metalAndColorPageSteps.selectRadios(testData.getFirstDigitInSummary(), testData.getSecondDigitInSummary());
        }

        //Click on submit button
        metalAndColorPageSteps.submit();

        //Assert result
        metalAndColorPageSteps.assertResult(testData);
    }
}