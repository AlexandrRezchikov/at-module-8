package org.example.framework.asserts;

import org.example.framework.common.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertsElements {

    public static void checkVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), String.format("Element '%s' is not displayed", element.getAccessibleName()));
    }

    public static void equalsInteger(int integer, int i) {
        Assert.assertEquals(integer, i, " количество не равно!");
    }

    public static void checkColorErrorMessage(WebElement element) {
        Assert.assertEquals(element.getCssValue("color"), "rgba(230, 79, 79, 1)", "Цвет текста ошибки не красный!");
    }

    public static void checkAllErrorMessages() {
        for (ErrorMessage errorMessage : ErrorMessage.values()) {
            try {
                checkErrorMessage(errorMessage);
                System.out.println("[Проверка прошла успешно для ошибки: " + errorMessage.getText() + "]");
            } catch (NoSuchElementException e) {
                System.out.println("[Элемент с текстом ошибки '" + errorMessage.getText() + "' не найден.]");
            } catch (AssertionError e) {
                System.out.println("[Проверка не прошла для ошибки: " + errorMessage.getText() + "]");
            }
        }
    }

    public static void checkErrorMessage(ErrorMessage errorMessage) {
        Assert.assertEquals(errorMessage.getText(), DriverActions.getDriver()
                .findElement(By.cssSelector(String.format(".as-input__message", errorMessage.getText()))).getText());
    }

    public enum ErrorMessage {
        ERROR_DATE("Поле обязательно для заполнения"),
        ERROR_FULL_NAME("Поле обязательно для заполнения"),
        ERROR_PHONE_NUMBER("Введите корректный номер телефона"),
        ERROR_EMAIL("Введите корректный e-mail");

        private final String text;

        ErrorMessage(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }
    }
}
