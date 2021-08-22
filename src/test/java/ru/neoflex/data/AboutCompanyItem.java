package ru.neoflex.data;

public enum AboutCompanyItem {
    ABOUT_COMPANY_ITEM("О компании"),
    MANAGEMENT("Менеджмент"),
    HISTORY("История"),
    PARTNERS("Партнеры"),
    CLIENTS("Клиенты");

    private String displayName;

    AboutCompanyItem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
