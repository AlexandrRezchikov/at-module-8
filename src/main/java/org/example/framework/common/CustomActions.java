package org.example.framework.common;

import org.example.framework.asserts.AssertsElements;
import org.openqa.selenium.WebElement;

public class CustomActions {

    public static void checkAndClick(WebElement element) {
        AssertsElements.checkVisible(element);
        element.click();
    }
}
