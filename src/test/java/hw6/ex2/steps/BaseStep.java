package hw6.ex2.steps;

// TODO Unused imports
import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.ex2.hooks.TestContext;

// TODO This class is duplicated for the BaseStep from hw6.ex2.steps
public abstract class BaseStep {

    protected HomePage homePage;
    protected UserTablePage userTablePage;

    public BaseStep() {
        homePage                = HomePage.getInstance(TestContext.getDriver());
        userTablePage           = UserTablePage.getInstance(TestContext.getDriver());
    }

}