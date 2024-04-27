package org.example.framework.enums;

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
