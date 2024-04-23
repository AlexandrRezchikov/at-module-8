package org.example.framework.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.framework.config.Config.EXPLICIT_WAIT;

public class CustomWait {

    public static WebElement waitTextToBePresentInElement(WebElement element) {
        new WebDriverWait(DriverActions.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.textToBePresentInElement(element, "Найден"));
        return element;
    }

    public static WebElement waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverActions.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
