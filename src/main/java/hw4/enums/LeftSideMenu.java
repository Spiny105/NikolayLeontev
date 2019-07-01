package hw4.enums;

public enum LeftSideMenu {

    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENTS_PACKS("Elements packs");


    final String name;

    LeftSideMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
