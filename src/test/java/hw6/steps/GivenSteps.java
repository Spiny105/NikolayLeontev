package hw6.steps;

import cucumber.api.java.en.Given;
import hw6.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

// TODO Code duplication from hw6.ex1.steps (fixed)
public class GivenSteps extends BaseStep {

    @Given("I am on the JDI Index Page")
    public void iAmOnTheJdiIndexPage() {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
    }

    @Given("^I am on \"([^\"]*)\"$")
    public void iAmOnHomePage(String title) {
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
        assertEquals(homePage.getPageTitle(), title);
    }


    @Given("^I login as user \"([^\"]*)\" with login \"([^\"]*)\" and password \"([^\"]*)\"$")
    // TODO Why do you decide hardcoded username and password? (fixed)
    public void loginAsUser(String expectedUsername, String login, String password) {

        homePage.login(login, password);

        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername.toUpperCase());
    }

}
