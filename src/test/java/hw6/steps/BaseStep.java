package hw6.steps;


import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.hooks.TestContext;

public abstract class BaseStep {

    protected HomePage homePage;
    protected UserTablePage userTablePage;
    protected DifferentElementsPage differentElementsPage;

    public BaseStep() {
        homePage = HomePage.getInstance(TestContext.getDriver());
        userTablePage = UserTablePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
    }

}