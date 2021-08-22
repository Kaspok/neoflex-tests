package ru.neoflex.data;

public enum SolutionsItem {
    OPEN_API("Open API"),
    ENTERPRISE_DATA_LAKE("Enterprise Data Lake"),
    REMOTE_BANKING_SERVICES("Дистанционное банковское обслуживание"),
    LOAN_ORIGINATION_AND_CREDIT_SCORING("Кредитный конвейер"),
    REGULATORY_REPORTING("Обязательная отчетность"),
    APPLICATION_INTEGRATION("Интеграция приложений"),
    ACTIVE_ARCHIVE("Active Archive"),
    TRANSPORTATION_MANAGEMENT("Управление перевозками "),
    KNOW_YOUR_CUSTOMER("KYC и ПОД/ФТ"),
    TREASURY_AUTOMATION("Автоматизация казначейства"),
    RISK_MANAGEMENT("Управление рисками банка"),
    AUTOMATION_OF_IFRS9_REQUIREMENTS("Автоматизация требований IFRS9"),
    SERVICING_AND_LENDING("Обслуживание и кредитование МСБ"),
    SECURITY_OPERATIONS_CENTER("Security Operations Center "),
    NEOFLEX_LOAN_BUREAU_VAS("Neoflex Loan Bureau VAS");

    private String displayName;

    SolutionsItem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
