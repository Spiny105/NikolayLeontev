package hw6.enums;

public enum DifferentElementsPageRadios {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String name;

    DifferentElementsPageRadios(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
