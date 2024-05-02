package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.asserts.AssertsElements;
import org.example.framework.common.DriverActions;
import org.example.framework.enums.Colors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.example.framework.utils.DataGeneration;
import org.example.framework.common.CustomActions;

public class ApplicationForTourPage extends BasePage {

    @FindBy(css = ".as-input__append")
    private WebElement barOfSelectingTourDate;

    @FindBy(xpath = "//li[@class='as-select__list-item']//strong[text()='3—5 мая']")
    private WebElement dateOfTour;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement textBarName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement textBarPhoneNumber;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement textBarEmail;

    @FindBy(xpath = "//button[@name='submit']")
    private WebElement buttonSendRequest;

    @FindBy(css = ".as-input__message")
    private WebElement errorMessageValidating;

    @FindBy(xpath = ".//span[contains(., 'Вернуться')]")
    private WebElement buttonGoToBack;

    @Step("Проверка Title страницы бронирования тура")
    public ApplicationForTourPage checkTitle() {
        waitElementIsVisible(buttonGoToBack);
        String title = DriverActions.getDriver().getTitle();
        Assert.assertTrue(title.contains("Заявка на тур | Большая Страна"));
        return this;
    }

    @Step("Выбор дат в форме брони")
    public ApplicationForTourPage selectingDate() {
        AssertsElements.checkVisible(barOfSelectingTourDate);
        barOfSelectingTourDate.click();
        dateOfTour.click();
        return this;
    }

    @Step("Заполнение поля ФИО в форме брони")
    public ApplicationForTourPage enteringName() {
        String fullName = DataGeneration.generateFullName();
        CustomActions.checkAndClick(textBarName);
        textBarName.sendKeys(fullName);
        return this;
    }

    @Step("Заполнение поля номера телефона в форме брони")
    public ApplicationForTourPage enteringPhoneNumber() {
        String phoneNumber = DataGeneration.generatePhoneNumber();
        CustomActions.checkAndClick(textBarPhoneNumber);
        textBarPhoneNumber.sendKeys(phoneNumber);
        return this;
    }

    @Step("Заполнение поля email в форме брони")
    public ApplicationForTourPage enteringEmail() {
        String email = DataGeneration.generateEmail();
        CustomActions.checkAndClick(textBarEmail);
        textBarEmail.sendKeys(email);
        return this;
    }

    @Step("Отправка заполненной формы брони")
    public ApplicationForTourPage sendApplication() {
        CustomActions.checkAndClick(buttonSendRequest);
        return this;
    }

    @Step("Проверка ошибки")
    public ApplicationForTourPage checkingErrorMessage(String field, String text) {
        WebElement testField = DriverActions.getDriver().findElement(By.xpath(String.format(".//*[@class='as-input__label' and .//input[@name='%s']]", field)));
        AssertsElements.checkVisible(testField);
        AssertsElements.validatingColorText(testField.findElement(By.className("as-input__label-text")), Colors.RED);
        AssertsElements.validatingTextMessage(testField.findElement(By.className("as-input__message")), text);
        AssertsElements.validatingColorText(testField.findElement(By.className("as-input__message")), Colors.RED);
        return this;
    }
}

//        AssertsElements.checkTextErrorMessages(ErrorMessage.values());
//        System.out.println("Текст ошибки: " + errorMessageValidating.getText());
