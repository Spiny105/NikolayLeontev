package hw4.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import hw4.TableWithPagesPage;

import static com.codeborne.selenide.Condition.*;

public class TableWithPagesPageSteps {

    TableWithPagesPage tableWithPagesPage;

    public TableWithPagesPageSteps(String url){
        tableWithPagesPage = Selenide.open(url, TableWithPagesPage.class);
    }

    public void assertShowEntriesDropDownValue(String expected)
    {
        tableWithPagesPage.getEntriesDropdownValue().shouldBe(text(expected));
    }

    public void assertLeftSection(){
        tableWithPagesPage.getLeftSection().shouldBe(visible);
    }

    public void assertRightSection(){
        tableWithPagesPage.getRightSection().shouldBe(visible);
    }

    public void selectNewValueInDropdownList(String value){
        tableWithPagesPage.getEntriesDropdownValue().selectOption(value);
        tableWithPagesPage.getEntriesDropdownValue().shouldHave(text(value));

        String expectedMatchText = "Datatable Events: length, new value="+value;
        tableWithPagesPage.getLogMessageElement(2).shouldHave(matchText(expectedMatchText));
    }

    public void assertTableRowsCount(int expectedRowCount){
        tableWithPagesPage.getTableRows().shouldHaveSize(expectedRowCount);
    }

    public void typeTextInSearchField(String text){
        tableWithPagesPage.typeTextInSearchField(text);
    }

    public void assertAllRecordsInTableContainsText(String text){

        for (SelenideElement element : tableWithPagesPage.getNowCollumnRecords()){
            element.shouldHave(matchText(text));
        }
    }
}
