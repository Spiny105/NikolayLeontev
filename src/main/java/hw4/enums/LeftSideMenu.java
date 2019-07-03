package hw4.enums;

import java.util.Arrays;
import java.util.List;

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

    public static List<LeftSideMenu> getAllElements(){
        return Arrays.asList(HOME, CONTACT_FORM, SERVICE, METALS_AND_COLORS, ELEMENTS_PACKS);
    }
}
