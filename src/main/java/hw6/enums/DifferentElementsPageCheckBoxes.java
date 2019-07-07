package hw6.enums;

public enum DifferentElementsPageCheckBoxes {

    WATER("Water"),
    WIND("Wind"),
    FIRE("Fire"),
    EARTH("Earth");

    final String name;

    DifferentElementsPageCheckBoxes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
