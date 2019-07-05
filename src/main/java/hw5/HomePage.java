package hw5;

import hw5.enums.ServiceElementsMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href = 'https://github.com/epam/JDI']")
    private WebElement subHeader;

    @FindBy(id = "epam_logo")
    private WebElement epamLogo;

    @FindBy(id = "iframe")
    WebElement iFrame;

    @FindBy(name = "jdi-text")
    private WebElement pageText;

    @FindBy(name = "main-title")
    private WebElement mainHeader;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(className = "benefit-txt")
    private List<WebElement> benefitTexts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getBenefitIcons()
    {
        return benefitIcons;
    }

    public List<WebElement> getBenefitTexts() {
        return benefitTexts;
    }

    public String getMainHeaderText(){
        return mainHeader.getText();
    }

    public String getPageText(){
        return pageText.getText();
    }

    public WebElement getiFrame() {
        return iFrame;
    }

    public void switchToIFrame(){
        driver.switchTo().frame(iFrame);
    }

    public void switchToOriginalPage(){
        driver.switchTo().defaultContent();
    }

    public WebElement getEpamLogo() {
        return epamLogo;
    }

    public WebElement getSubHeader() {
        return subHeader;
    }

    public List<WebElement> getServiceItems(){ return serviceItems; }

    public void clickOnServiceItem(ServiceElementsMenu serviceElementsMenu){
        serviceItems.stream().filter(x->x.getText().equals(serviceElementsMenu.getName())).findFirst().orElse(null).click();
    }

}
