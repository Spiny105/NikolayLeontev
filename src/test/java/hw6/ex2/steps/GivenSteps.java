package hw6.ex2.steps;

import cucumber.api.java.en.Given;
import hw6.ex2.hooks.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

// TODO Code duplication from hw6.ex1.steps
public class GivenSteps extends BaseStep{

    @Given("^I am on \"([^\"]*)\"$")
    public void iAmOnHomePage(String title){
        TestContext.getDriver().get("https://epam.github.io/JDI/index.html");
        assertEquals(homePage.getPageTitle(), title);
    }

    @Given("^I login as user \"([^\"]*)\"$")
    // TODO Why do you decide hardcoded username and password?
    public void loginAsUser(String expectedUsername){

        homePage.login("epam","1234");

        WebElement userNameWebElement = TestContext.getDriver().findElement(By.id("user-name"));
        assertEquals(userNameWebElement.getText(), expectedUsername.toUpperCase());
    }

}
