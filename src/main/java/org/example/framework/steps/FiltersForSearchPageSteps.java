package org.example.framework.steps;

import org.example.framework.pages.AllPages;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FiltersForSearchPageSteps extends AllPages {

    @Then("пользователь видит на странице количество найденных туров")
    public void userSeesNumberOfToursFound() {
        filtersForSearchPage.checkingCountTours();
    }

    @When("пользователь выбирает дополнительные фильтры для поиска")
    public void userSelectsAdditionalFilters() {
        filtersForSearchPage.selectFilters();
    }

    @Then("пользователь видит количество найденных туров соответствующих параметрам поиска")
    public void userSeesNumberOfToursMatchingSearchParameters() {
        filtersForSearchPage.checkingCountTours();
    }

    @When("пользователь изменяет фильтр стоимости")
    public void changingPriceOfTour() {
        filtersForSearchPage.moveSliderPrice();
    }

    @When("пользователь нажимает на карточку тура")
    public void clickCardTour() {
        filtersForSearchPage.watchInfoOfTour();
    }
}
