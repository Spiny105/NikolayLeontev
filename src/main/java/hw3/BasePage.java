package hw3;

import hw3.enums.LeftSideMenu;
import hw3.enums.ServiceElementsMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]//ul[@class = 'sub']//a")
    protected List<WebElement> serviceItems;

    @FindBy(xpath = "//*[@id=\"mCSB_1_container\"]/ul[@class= 'sub']//a")
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
