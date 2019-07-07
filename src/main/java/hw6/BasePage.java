package hw6;

import hw6.enums.LeftSideMenu;
import hw6.enums.ServiceElementsMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(id = "user-icon")
    protected WebElement userIcon;

    @FindBy(id = "name")
    protected WebElement loginNameTextField;

    protected WebElement password;

    @FindBy(xpath = "//button[@id='login-button']")
    protected WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]//ul[@class = 'sub']//a")
    protected List<WebElement> serviceItems;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]//span")
    protected List<WebElement> leftSidebarItems;

    @FindBy(id = "mCSB_1")
    protected WebElement leftSection;

    @FindBy(className = "footer-bg")
    protected WebElement footer;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password) {
        userIcon.click();
        loginNameTextField.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void clickLeftSideMenu(LeftSideMenu menuItem) {
        driver.findElement(By.linkText(menuItem.getName())).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getUserName(){
        return driver.findElement(By.id("user-name")).getText();
    }

    public List<WebElement> getLeftSidebarItems(){
        return leftSidebarItems;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getLeftSection() {
        return leftSection;
    }

    public void clickOnServiceSubcategoryItem(ServiceElementsMenu element){
        serviceItems.stream().filter(x->x.getText().equals(element.getName())).findFirst().orElse(null).click();
    }
}
