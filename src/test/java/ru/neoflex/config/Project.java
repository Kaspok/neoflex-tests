package ru.neoflex.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);

    public static boolean isRemoteWebDriver() {
        return !projectConfig.remoteDriverUrl().equals("");
    }
}
