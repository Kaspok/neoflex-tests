package ru.neoflex.data;

public enum MenuItem {
    SOLUTIONS("Решения"),
    PROJECTS("Проекты"),
    EXPERTISE("Экспертиза"),
    ABOUT_COMPANY("О компании"),
    CAREER("Карьера"),
    PRESS_CENTER("Пресс-центр"),
    CONTACTS("Контакты"),
    EN("EN");

    private String displayName;

    MenuItem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
