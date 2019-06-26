package hw3.enums;

public enum ServiceElementsMenu {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex table"),
    SIMPLE_TABLE("Simple table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements");


    final String name;

    ServiceElementsMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
