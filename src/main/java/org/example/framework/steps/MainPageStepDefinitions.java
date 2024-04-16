package org.example.framework.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class MainPageStepDefinitions extends BaseStepDefinitions {

    @Given("пользователь находится на главной странице")
    public void userIsOnHomePage() {
        mainPage.checkTitle();
    }

    @When("пользователь вводит регион $nameRegion и выбирает параметры для посика тура")
    public void userEntersRegionAndSelectsTourParameters(String nameRegion) {
        mainPage.selectingRegion(nameRegion)
                .selectingViewRecreation()
                .selectingDate();
    }

    @When("пользователь нажимает на кнопку найти туры")
    public void userClicksFindToursButton() {
        mainPage.clickButtonOfSearch();
    }
}
