package org.example.patterns.singelton;

public class ConfigurationManager {
    private String dbUrl = "Default url";
    private String storagePath = "Default storagePath";
    private String logsPath = "Default logsPath";

    private static ConfigurationManager configurationManager;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }
}
