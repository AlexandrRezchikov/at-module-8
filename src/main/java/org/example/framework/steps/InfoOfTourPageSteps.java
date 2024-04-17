package org.example.framework.steps;

import org.example.framework.common.DriverActions;
import org.example.framework.pages.AllPages;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class InfoOfTourPageSteps extends AllPages {

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
