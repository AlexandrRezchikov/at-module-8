package org.example.framework.steps;

import org.example.framework.common.DriverActions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class InfoOfTourPageStepDefinitions extends BaseStepDefinitions {

    @Then("пользователь переходит на страницу тура")
    public void pageInfoOfTour() {
        DriverActions.switchToFrame();
        infoOfTour.checkTourPage();
    }

    @When("пользователь нажимает на кнопку 'Забронировать места'")
    public void clickButtonReserve() {
        infoOfTour.switchingToPageBookYourPlace();
    }
}
