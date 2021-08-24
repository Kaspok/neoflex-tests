package ru.neoflex.data;

public enum ExpertiseItem {
    FAST_DATA("Fast Data"),
    MICROSERVICES("Микросервисы"),
    DEVOPS("DevOps"),
    DATA_SCIENCE("Data Science"),
    MLOPS("MLOps"),
    BIG_DATA("Big Data"),
    UX_UI("UX/UI"),
    SUITECRM("SuiteCRM"),
    SITE_RELIABILITY_ENGINEERING("Site Reliability Engineering"),
    CLOUD_SERVICES("Cloud Services"),
    NEOFLEX_MSA_PLATFORM("Cloud Services"),
    NEOFLEX_DATAGRAM("Neoflex MSA Platform"),
    CUSTOM_SOFTWARE_DEVELOPMENT("Заказная разработка ПО");

    private String displayName;

    ExpertiseItem(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
