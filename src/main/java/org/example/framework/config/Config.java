package org.example.framework.config;

public class Config {

    // ОС и браузер
    public static final String BROWSER = ConfigReader.browser();

    // Очистка cookies
    // if true - очистить cookies
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = ConfigReader.clearCookiesAndStorage();

    // Закрытие браузера
    // if true - браузер закрывается
    public static final Boolean HOLD_BROWSER_OPEN = ConfigReader.holdBrowserOpen();

    public static final String URL = ConfigReader.url();

    public static final String NAME_REGION = ConfigReader.nameRegion();

    public static final int IMPLICIT_WAIT = ConfigReader.implicitWait();

    public static final int EXPLICIT_WAIT = ConfigReader.explicitWait();

}
