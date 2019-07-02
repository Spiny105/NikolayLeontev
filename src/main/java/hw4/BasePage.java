package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.LeftSideMenu;
import hw4.enums.ServiceElementsMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(id = "user-icon")
    protected SelenideElement userIcon;

    @FindBy(id = "name")
    protected SelenideElement loginNameTextField;

    @FindBy(id = "user-name")
    protected SelenideElement userName;

    protected SelenideElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    protected SelenideElement loginButton;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]//ul[@class = 'sub']//a")
    protected ElementsCollection serviceItems;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]//span")
    protected ElementsCollection leftSidebarItems;

    @FindBy(id = "mCSB_1")
    protected SelenideElement leftSection;

    @FindBy(className = "footer-bg")
    protected SelenideElement footer;

    public BasePage() {
        Selenide.page(this);
    }

    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void clickLeftSideMenu(LeftSideMenu menuItem) {
        Selenide.element(By.linkText(menuItem.getName())).click();
    }

    public String getPageTitle() {
        return Selenide.title();
    }

    public SelenideElement getUserName(){
        return userName;
    }

    public ElementsCollection getLeftSidebarItems(){
        return leftSidebarItems;
    }

    public SelenideElement getFooter() {
        return footer;
    }

    public SelenideElement getLeftSection() {
        return leftSection;
    }

    public void clickOnServiceSubcategoryItem(ServiceElementsMenu element){
        serviceItems.stream().filter(x->x.getText().equals(element.getName())).findFirst().orElse(null).click();
    }

    public ElementsCollection getServiceItems(){ return serviceItems; }
}
