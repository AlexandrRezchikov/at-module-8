package org.example.framework.checker;

import org.example.framework.common.DriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class ErrorMessageChecker {
    public static void textError(ErrorMessage errorMessage) throws NoSuchElementException {
        String text = errorMessage.getText();
        if (DriverActions.getDriver().findElements(By.cssSelector(String.format(".as-input__message", text))).isEmpty()) {
            throw new NoSuchElementException("Ошибка: Элемент с текстом " + text + " не найден!");
        }
    }

//    public static void textError(ErrorMessage errorMessage) {
//        String text = errorMessage.getText();
//        assert !DriverActions.getDriver().findElements(By.cssSelector(String.format(".as-input__message", text))).isEmpty() : "Ошибка: Элемент с текстом " + text + " не найден!";
//    }

    public enum ErrorMessage {
        ERROR_DATE("Поле обязательно для заполнения"),
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
