package hw6.ex1.steps;

import hw6.DifferentElementsPage;
import hw6.HomePage;
import hw6.ex1.hooks.TestContext;

public abstract class BaseStep {

    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public BaseStep() {
        homePage = HomePage.getInstance(TestContext.getDriver());
        differentElementsPage = DifferentElementsPage.getInstance(TestContext.getDriver());
    }

}