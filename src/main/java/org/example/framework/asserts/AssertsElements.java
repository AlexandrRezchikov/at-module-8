package org.example.framework.asserts;

import org.example.framework.enums.Colors;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class AssertsElements {

    public static void checkVisible(WebElement element) {
        assertTrue(element.isDisplayed(), String.format("Element '%s' is not displayed", element.getAccessibleName()));
    }

    public static void equalsInteger(int integer, int i) {
        Assert.assertEquals(integer, i, " количество не равно!");
    }

    public static void validatingColorText(WebElement element, Colors expectedColor) {
        Assert.assertEquals(element.getCssValue("color"), expectedColor.getRGBA());
    }

//    public static void checkTextErrorMessages(ErrorMessage[] errorMessages) {
//        for (ErrorMessage errorMessage : errorMessages) {
//            checkErrorMessage(errorMessage);
//        }
//    }
//
//    public static void checkErrorMessage(ErrorMessage errorMessage) {
//        try {
//            Assert.assertTrue((DriverActions.getDriver()
//                    .findElement(By.xpath("//span[contains(text(), '" + errorMessage.getText() + "')]"))
//            ).isDisplayed(), "[Элемент с текстом ошибки '" + errorMessage.getText() + "' не видим.]");
//            System.out.println("[Элемент с текстом ошибки '" + errorMessage.getText() + "' найден.]");
//        } catch (NoSuchElementException e) {
//            System.out.println("[Элемент с текстом ошибки '" + errorMessage.getText() + "' не найден.]");
//        }
//    }

    public static void validatingTextMessage(WebElement element, String text) {
        Assert.assertEquals(element.getText(), text);
    }
}
