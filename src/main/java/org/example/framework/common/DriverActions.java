package org.example.framework.common;

import org.example.framework.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class DriverActions {

    private static WebDriver driver;

    private static Actions actions;

    private static void createDriver() {

        switch (Config.BROWSER) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
            default:
                Assert.fail("Incorrect platform or browser name: " + Config.BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.IMPLICIT_WAIT));
        actions = new Actions(driver);
    }

    public static void setDriver() {
        if (driver == null)
            createDriver();
    }

    public static WebDriver getDriver() {
        setDriver();
        return driver;
    }

    public static Actions getActions() {
        return actions;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    public static void switchToFrame() {
        String currentWindowHandle = DriverActions.getDriver().getWindowHandle();
        Set<String> windowHandles = DriverActions.getDriver().getWindowHandles();
        String nextWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                nextWindowHandle = handle;
                break;
            }
        }
        DriverActions.getDriver().switchTo().window(nextWindowHandle);
    }

}
