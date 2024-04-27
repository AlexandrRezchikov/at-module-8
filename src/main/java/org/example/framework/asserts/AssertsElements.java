package org.example.framework.asserts;

import org.example.framework.common.DriverActions;
import org.example.framework.enums.Colors;
import org.example.framework.enums.ErrorMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AssertsElements {

    public static void checkVisible(WebElement element) {
        assertTrue(element.isDisplayed(), String.format("Element '%s' is not displayed", element.getAccessibleName()));
    }

    public static void equalsInteger(int integer, int i) {
        Assert.assertEquals(integer, i, " количество не равно!");
    }

    public static void checkColorTextError(WebElement element, Colors expectedColor) {
        Assert.assertEquals(element.getCssValue("color"), expectedColor.getRGBA());
    }

    public static void checkTextErrorMessages(ErrorMessage[] errorMessages) {
        for (ErrorMessage errorMessage : errorMessages) {
            checkErrorMessage(errorMessage);
        }
    }

    public static void checkErrorMessage(ErrorMessage errorMessage) {

        List<WebElement> elements = DriverActions.getDriver().findElements(By.xpath("//span[contains(text(), '" + errorMessage.getText() + "')]"));
        if (elements.size() > 0) {
            assertTrue(elements.get(0).isDisplayed(), "[Элемент с текстом ошибки '" + errorMessage.getText() + "' не видим.]");
        }
    }
}
