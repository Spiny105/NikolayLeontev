package hw4.ex2;

import hw4.BaseTest;
import hw4.enums.DifferentElements;
import hw4.enums.Colors;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import hw4.steps.HomePageSteps;
import hw4.steps.MetalAndColorPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTest extends BaseTest {

    private HomePageSteps homePageSteps;
    private MetalAndColorPageSteps metalAndColorPageSteps;

    @DataProvider(name = "test-data")
    public Object[][] dataProviderMethod() {

        Object[][] data = new Object[5][];

        data[0] = new Object[]{null, null, Arrays.asList(DifferentElements.EARTH), Colors.YELLOW,
                Metals.GOLD, null};

        data[1] = new Object[]{3, 8, null, null, null, Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO)};

        data[2] = new Object[]{3, 2,
                Arrays.asList(DifferentElements.WIND, DifferentElements.FIRE, DifferentElements.WATER),
                null, Metals.BRONZE, Arrays.asList(Vegetables.ONION)};

        data[3] = new Object[]{5, 6, Arrays.asList(DifferentElements.WATER), Colors.GREEN,
                Metals.SELEN, Arrays.asList(Vegetables.ONION, Vegetables.TOMATO, Vegetables.CUCUMBER, Vegetables.VEGETABLES)};

        data[4] = new Object[]{null, null, null, null, null, null};

        return data;
    }

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePageSteps = new HomePageSteps("https://epam.github.io/JDI");
        metalAndColorPageSteps = new MetalAndColorPageSteps("https://epam.github.io/JDI");
    }

    @Test(dataProvider = "test-data")
    public void testScenario(Integer firstDigitInSummary, Integer secondDigitInSummary,
                             List<DifferentElements> differentElementsToCheck, Colors colorToSelect,
                             Metals metalToSelect, List<Vegetables> vegetablesToCheck) {

        //Assert Browser title
        homePageSteps.assertPageTitle("Home Page");

        //Login
        homePageSteps.login(login, password);

        //Assert user name
        homePageSteps.assertUserName(userName);

        //Open "Different Elements" page
        homePageSteps.goToMetalAndColorsPage();

        //Fill form
        if (vegetablesToCheck != null) {
            metalAndColorPageSteps.selectVegetables(vegetablesToCheck);
        }

        if (metalToSelect != null) {
            metalAndColorPageSteps.selectMetal(metalToSelect);
        }

        if (colorToSelect != null) {
            metalAndColorPageSteps.selectColor(colorToSelect);
        }

        if (differentElementsToCheck != null) {
            metalAndColorPageSteps.selectDifferentElements(differentElementsToCheck);
        }

        if ((firstDigitInSummary != null) && (secondDigitInSummary != null)) {
            metalAndColorPageSteps.selectRadios(firstDigitInSummary, secondDigitInSummary);
        }

        //Click on submit button
        metalAndColorPageSteps.submit();

        //Assert result
        metalAndColorPageSteps.assertResult(firstDigitInSummary, secondDigitInSummary, differentElementsToCheck,
                colorToSelect, metalToSelect, vegetablesToCheck);
    }
}