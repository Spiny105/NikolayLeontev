package hw4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import hw4.MetalAndColorPage;
import hw4.builder.MetalAndColorPageTestData;
import hw4.enums.Colors;
import hw4.enums.DifferentElements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;

import java.util.List;

public class MetalAndColorPageSteps {

    public MetalAndColorPage metalAndColorPage;

    public MetalAndColorPageSteps(String url) {
        metalAndColorPage = Selenide.open(url, MetalAndColorPage.class);
    }

    public void selectMetal(Metals metal) {
        metalAndColorPage.getMetalsArrow().click();
        metalAndColorPage.getMetals().findBy(Condition.text(metal.getName())).click();
    }

    public void selectColor(Colors color) {
        metalAndColorPage.getColorsArrow().click();
        metalAndColorPage.getColors().findBy(Condition.text(color.getName())).click();
    }

    public void selectVegetables(List<Vegetables> selectedVegetables) {
        metalAndColorPage.getVegetablesArrow().click();

        for (Vegetables v : selectedVegetables) {
            metalAndColorPage.getVagetablesCheckboxes().findBy(Condition.text(v.getName())).click();
        }
    }

    public void selectRadios(Integer first, Integer second) {
        metalAndColorPage.getOddSummaryRadios().findBy(Condition.matchText(first.toString())).click();
        metalAndColorPage.getEvenSummaryRadios().findBy(Condition.matchText(second.toString())).click();
    }

    public void selectDifferentElements(List<DifferentElements> elements) {

        for (DifferentElements element : elements) {
            metalAndColorPage.getElementsCheckboxes().findBy(Condition.text(element.getName())).click();
        }
    }

    public void assertResult(MetalAndColorPageTestData testData) {

        ElementsCollection resultRecords = metalAndColorPage.getResultRecords();

        //Assert summary
        if ( (testData.getFirstDigitInSummary() != null) && (testData.getSecondDigitInSummary() != null)) {
            resultRecords.stream().filter(x -> x.getText()
                    .contains("Summary: " + (testData.getFirstDigitInSummary() + testData.getSecondDigitInSummary()))).findFirst().get().shouldBe(Condition.visible);
        } else {
            resultRecords.stream().filter(x -> x.getText()
                    .contains("Summary: 3")).findFirst().get().shouldBe(Condition.visible);
        }

        //Assert selected elements
        if (testData.getDifferentElementsToCheck() != null) {
            for (DifferentElements element : testData.getDifferentElementsToCheck()) {
                resultRecords.stream().filter(x -> x.getText().contains(element.getName())).findFirst().get().shouldBe(Condition.visible);
            }
        }

        //Assert selected color
        if (testData.getColorToSelect() != null) {
            resultRecords.stream().filter(x -> x.getText().contains(testData.getColorToSelect().getName())).findFirst().get().shouldBe(Condition.visible);
        }else{
            resultRecords.stream().filter(x -> x.getText().contains("Colors")).findFirst().get().shouldBe(Condition.visible);
        }

        //Assert selected metal
        if (testData.getMetalToSelect() != null) {
            resultRecords.stream().filter(x -> x.getText().contains(testData.getMetalToSelect().getName())).findFirst().get().shouldBe(Condition.visible);
        }else{
            resultRecords.stream().filter(x -> x.getText().contains("Metals")).findFirst().get().shouldBe(Condition.visible);
        }

        //Assert selected vegetables
        if (testData.getVegetablesToCheck() != null)
        for (Vegetables v : testData.getVegetablesToCheck()) {
            resultRecords.stream().filter(x -> x.getText().contains(v.getName())).findFirst().get().shouldBe(Condition.visible);
        }
    }

    public void submit() {
        metalAndColorPage.getSubmitButton().click();
    }
}
