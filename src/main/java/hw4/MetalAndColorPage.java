package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MetalAndColorPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"mCSB_2_container\"]//section[2]//li")
    private ElementsCollection resultRecords;

    @FindBy(xpath = "//*[@id='even-selector']//label")
    private ElementsCollection evenSummaryRadios;

    @FindBy(xpath = "//*[@id=\"odds-selector\"]//label")
    private ElementsCollection oddSummaryRadios;

    @FindBy(id = "submit-button")
    private SelenideElement submitButton;

    @FindBy(xpath = "//*[@id='elements-checklist']//label")
    private ElementsCollection elementsCheckboxes;

    @FindBy(xpath = "//*[@id=\"salad-dropdown\"]/button/span")
    private SelenideElement vegetablesArrow;

    @FindBy(xpath = "//*[@id=\"salad-dropdown\"]/ul//label")
    private ElementsCollection vagetablesCheckboxes;

    @FindBy(xpath = "//button[@title='Metals']/span[@class='caret']")
    private SelenideElement metalsArrow;

    @FindBy(xpath = "//*[@id=\"metals\"]//ul//a")
    private ElementsCollection metals;

    @FindBy(xpath = "//button[@title='Colors']/span[@class='caret']")
    private SelenideElement colorsArrow;

    @FindBy(xpath = "//*[@id=\"colors\"]//ul//a")
    private ElementsCollection colors;

    public ElementsCollection getEvenSummaryRadios() {
        return evenSummaryRadios;
    }

    public ElementsCollection getOddSummaryRadios() {
        return oddSummaryRadios;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }

    public ElementsCollection getElementsCheckboxes() {
        return elementsCheckboxes;
    }

    public SelenideElement getVegetablesArrow() {
        return vegetablesArrow;
    }

    public ElementsCollection getVagetablesCheckboxes() {
        return vagetablesCheckboxes;
    }

    public SelenideElement getMetalsArrow() {
        return metalsArrow;
    }

    public ElementsCollection getMetals() {
        return metals;
    }

    public SelenideElement getColorsArrow() {
        return colorsArrow;
    }

    public ElementsCollection getColors() {
        return colors;
    }

    public ElementsCollection getResultRecords() {
        return resultRecords;
    }
}
