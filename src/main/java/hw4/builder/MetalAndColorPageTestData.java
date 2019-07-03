package hw4.builder;

import hw4.enums.Colors;
import hw4.enums.DifferentElements;
import hw4.enums.Metals;
import hw4.enums.Vegetables;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class MetalAndColorPageTestData {

    Integer firstDigitInSummary;
    Integer secondDigitInSummary;
    java.util.List<DifferentElements> differentElementsToCheck;
    Colors colorToSelect;
    Metals metalToSelect;
    List<Vegetables> vegetablesToCheck;
}
