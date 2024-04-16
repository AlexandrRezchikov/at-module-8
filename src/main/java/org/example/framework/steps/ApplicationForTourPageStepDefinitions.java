package org.example.framework.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ApplicationForTourPageStepDefinitions extends BaseStepDefinitions {

    @Then("пользователь переходит на страницу с формой для заполнения данных")
    public void pageApplicationForTour() {
        applicationForTourPage.checkTitle();
    }

    @When("пользователь выбирает дату")
    public void enteringDate() {
        applicationForTourPage.selectingDate();
    }

    @When("пользователь заполняет поле для ФИО")
    public void NameEntering() {
        applicationForTourPage.enteringName();
    }

    @When("пользователь заполняет поле для номера телефона")
    public void PhoneNumberEntering() {
        applicationForTourPage.enteringPhoneNumber();
    }

    @When("пользователь заполняет поле для почты")
    public void EmailEntering() {
        applicationForTourPage.enteringEmail();
    }

    @When("пользователь нажимает на кнопу 'Отправить заяву'")
    public void clickButtonSend() {
        applicationForTourPage.sendApplication();
    }

    @Then("пользователь видит сообщение что заявка отправлена")
    public void checkingSend() {
        applicationForTourPage.checkingErrorMessage();
    }
}
