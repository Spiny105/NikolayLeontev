package hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class TableWithPagesPage extends ServiseSubcategoryBasePage {

    @FindBy(xpath = "//input[@type = 'search']")
    private SelenideElement searchField;

    @FindBy(name = "table-with-pages_length")
    private SelenideElement entriesDropdown;

    @FindBy(xpath = "//tbody/tr[@role = 'row']")
    private ElementsCollection tableRows;

    @FindBy(xpath = "//tbody/tr/td[2]")
    private ElementsCollection nowCollumnRecords;

    public SelenideElement getEntriesDropdownValue() {
        return entriesDropdown;
    }

    public ElementsCollection getTableRows() {
        return tableRows;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public void typeTextInSearchField(String text){
        searchField.setValue(text);
    }

    public ElementsCollection getNowCollumnRecords(){
        return nowCollumnRecords;
    }
}
