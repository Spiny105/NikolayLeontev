package hw5.enums;

public enum DifferentElementsPageDropdownItems {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String name;

    DifferentElementsPageDropdownItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
