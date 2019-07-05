package hw5;

import hw5.enums.DifferentElementsPageDropdownItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends BasePage {

    @FindBy(xpath = "//select[@class = 'uui-form-element']")
    private WebElement dropDown;

    @FindBy(className = "panel-body-list logs")
    private WebElement logPanel;

    @FindBy(id = "mCSB_2")
    private WebElement rightSection;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(className = "colors")
    private WebElement dropdown;

    @FindBy(xpath = "//input[@value='Button']")
    private WebElement button;

    @FindBy(xpath = "//button[@value='Default Button']")
    private WebElement defaultButton;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getDefaultButton() {
        return defaultButton;
    }

    public WebElement getRightSection() {
        return rightSection;
    }

    public WebElement getLogPanel() {
        return logPanel;
    }

    public void selectDropDownValue(DifferentElementsPageDropdownItems item){
        dropDown.click();
        Select select = new Select(dropDown);
        select.selectByVisibleText(item.getName());
    }

    public String getLastLogMessage(){
        return driver.findElement(By.xpath("//ul[@class = 'panel-body-list logs']/li[1]")).getText();
    }
}