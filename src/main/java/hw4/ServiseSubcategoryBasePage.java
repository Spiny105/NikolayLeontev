package hw4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ServiseSubcategoryBasePage extends BasePage {

    @FindBy(id = "mCSB_2")
    protected SelenideElement rightSection;

    @FindBy(className = "panel-body-list logs")
    protected SelenideElement logPanel;

    public SelenideElement getRightSection(){
        return  rightSection;
    }

    public SelenideElement getLastLogMessageElement(){
        return Selenide.element(By.xpath("//ul[@class = 'panel-body-list logs']/li[1]"));
    }

    public String getLastLogMessage(){
        return getLastLogMessageElement().getText();
    }

    public SelenideElement getLogMessageElement(int number){
        return Selenide.element(By.xpath("//ul[@class = 'panel-body-list logs']/li[" + number + "]"));
    }
    public String getLogMessage(int number){
        return getLogMessageElement(number).getText();
    }
}
