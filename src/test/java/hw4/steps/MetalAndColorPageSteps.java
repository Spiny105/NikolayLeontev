package hw4.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import hw4.enums.DifferentElements;
import hw4.MetalAndColorPage;
import hw4.enums.Colors;
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

    public void assertResult(Integer firstDigitInSummary, Integer secondDigitInSummary,
                             List<DifferentElements> differentElementsToCheck, Colors colorToSelect,
                             Metals metalToSelect, List<Vegetables> vegetablesToCheck) {

        ElementsCollection resultRecords = metalAndColorPage.getResultRecords();

        //Assert summary
        if ( (firstDigitInSummary != null) && (secondDigitInSummary != null)) {
            resultRecords.stream().filter(x -> x.getText()
                    .contains("Summary: " + (firstDigitInSummary + secondDigitInSummary))).findFirst().get().shouldBe(Condition.visible);
        } else {
            resultRecords.stream().filter(x -> x.getText()
                    .contains("Summary: 3")).findFirst().get().shouldBe(Condition.visible);
        }

        //Assert selected elements
        if (differentElementsToCheck != null) {
            for (DifferentElements element : differentElementsToCheck) {
                resultRecords.stream().filter(x -> x.getText().contains(element.getName())).findFirst().get().shouldBe(Condition.visible);
            }
        }

        //Assert selected color
        if (colorToSelect != null) {
            resultRecords.stream().filter(x -> x.getText().contains(colorToSelect.getName())).findFirst().get().shouldBe(Condition.visible);
        }else{
            resultRecords.stream().filter(x -> x.getText().contains("Colors")).findFirst().get().shouldBe(Condition.visible);
        }

        //Assert selected metal
        if (metalToSelect != null) {
            resultRecords.stream().filter(x -> x.getText().contains(metalToSelect.getName())).findFirst().get().shouldBe(Condition.visible);
        }else{
            resultRecords.stream().filter(x -> x.getText().contains("Metals")).findFirst().get().shouldBe(Condition.visible);
        }

        //Assert selected vegetables
        if (vegetablesToCheck != null)
        for (Vegetables v : vegetablesToCheck) {
            resultRecords.stream().filter(x -> x.getText().contains(v.getName())).findFirst().get().shouldBe(Condition.visible);
        }
    }

    public void submit() {
        metalAndColorPage.getSubmitButton().click();
    }
}
