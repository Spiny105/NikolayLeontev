package hw4.enums;

public enum DifferentElements {

    WATER("Water"),
    WIND("Wind"),
    FIRE("Fire"),
    EARTH("Earth");

    final String name;

    DifferentElements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
