package org.example.framework.config;

import java.util.ResourceBundle;

public class ConfigReader {

    public static ResourceBundle config = ResourceBundle.getBundle("config");

    public static String browser() {
        return config.getString("browser");
    }

    public static boolean clearCookiesAndStorage() {
        return Boolean.parseBoolean(config.getString("clear_cookies_and_storage"));
    }

    public static boolean holdBrowserOpen() {
        return Boolean.parseBoolean(config.getString("hold_browser_open"));
    }

    public static String url() {
        return config.getString("url");
    }

    public static String nameRegion() {
        return config.getString("name_region");
    }

    public static int implicitWait() {
        return Integer.parseInt(config.getString("IMPLICIT_WAIT"));
    }

    public static int explicitWait() {
        return Integer.parseInt(config.getString("EXPLICIT_WAIT"));
    }
}
