package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.enums.ServiceElementsMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@href = 'https://github.com/epam/JDI']")
    private SelenideElement subHeader;

    @FindBy(id = "epam_logo")
    private SelenideElement epamLogo;

    @FindBy(id = "iframe")
    SelenideElement iFrame;

    @FindBy(name = "jdi-text")
    private SelenideElement pageText;

    @FindBy(name = "main-title")
    private SelenideElement mainHeader;

    @FindBy(className = "benefit-icon")
    private ElementsCollection benefitIcons;

    @FindBy(className = "benefit-txt")
    private ElementsCollection benefitTexts;

    public ElementsCollection getBenefitIcons()
    {
        return benefitIcons;
    }

    public ElementsCollection getBenefitTexts() {
        return benefitTexts;
    }

    public String getMainHeaderText(){
        return mainHeader.getText();
    }

    public String getPageText(){
        return pageText.getText();
    }

    public SelenideElement getiFrame() {
        return iFrame;
    }

    public void switchToIFrame(){
        Selenide.switchTo().frame(iFrame);
    }

    public void switchToOriginalPage(){
        Selenide.switchTo().defaultContent();
    }

    public SelenideElement getEpamLogo() {
        return epamLogo;
    }

    public SelenideElement getSubHeader() {
        return subHeader;
    }

    public void clickOnServiceItem(ServiceElementsMenu serviceElementsMenu){
        serviceItems.stream().filter(x->x.getText().equals(serviceElementsMenu.getName())).findFirst().orElse(null).click();
    }

}
