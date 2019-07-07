package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends BasePage {

    private static UserTablePage instance;

    @FindBy(xpath = "//*[@id=\"user-table\"]/tbody/tr/td[1]")
    private List<WebElement> numbersCollumn;

    @FindBy(xpath = "//*[@id=\"user-table\"]/tbody/tr/td[2]")
    private List<WebElement> namesCollumn;

    @FindBy(xpath = "//*[@id=\"user-table\"]/tbody//td[4]/div/span")
    private List<WebElement> descriptionTextsCollumn;

    @FindBy(xpath = "//*[@id=\"user-table\"]//select")
    private List<WebElement>  dropdowns;

    @FindBy(xpath = "//*[@id=\"user-table\"]//a")
    private List<WebElement>  userNames;

    @FindBy(xpath = "//*[@id=\"user-table\"]//img")
    private List<WebElement> descriptionImages;

    @FindBy(xpath = "//*[@id=\"user-table\"]//span")
    private List<WebElement> descriptionTexts;

    @FindBy(xpath = "//*[@id=\"user-table\"]//label")
    private List<WebElement> checkBoxes;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public static UserTablePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new UserTablePage(driver);
        }
        return instance;
    }

    public List<WebElement>  getDropdowns() {
        return dropdowns;
    }

    public List<WebElement>  getUserNames() {
        return userNames;
    }

    public List<WebElement> getDescriptionImages() {
        return descriptionImages;
    }

    public List<WebElement> getDescriptionTexts() {
        return descriptionTexts;
    }

    public List<WebElement> getCheckBoxes() {
        return checkBoxes;
    }

    public List<String> getLogMessages(){
        return driver.findElements(By.xpath("//*[@id=\"mCSB_2_container\"]/section[1]//li"))
                .stream()
                .map(x->x.getText())
                .collect(Collectors.toList());
    }

    public List<WebElement> getDropdownList(int dropdownList){
        return dropdowns.get(dropdownList).findElements(By.xpath("./option"));
    }

    public List<WebElement> getNumbersCollumn() {
        return numbersCollumn;
    }

    public List<WebElement> getNamesCollumn() {
        return namesCollumn;
    }

    public List<WebElement> getDescriptionTextsCollumn() {
        return descriptionTextsCollumn;
    }
}