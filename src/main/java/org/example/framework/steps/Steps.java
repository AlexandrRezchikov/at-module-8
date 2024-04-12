package org.example.framework.steps;

import io.qameta.allure.Allure;
import org.example.framework.common.DriverActions;
import org.example.framework.pages.AllPages;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.io.ByteArrayInputStream;

import static org.example.framework.config.Config.HOLD_BROWSER_OPEN;
import static org.example.framework.config.Config.URL;
import static org.example.framework.config.Config.CLEAR_COOKIES_AND_STORAGE;

public class Steps extends AllPages {

    public WebDriver driver;

    @BeforeStory
    public void setUp() {
        driver = DriverActions.getDriver();
        AllPages.init();
    }

    @AfterScenario(uponOutcome = AfterScenario.Outcome.FAILURE)
    public void afterScenario() {
        byte[] screenshot = ((TakesScreenshot) DriverActions.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot of the failed step", "image/png",
                new ByteArrayInputStream(screenshot), ".png");
    }

    @AfterStory
    public void closeAndClearCookies() {

        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverActions.getDriver();
            DriverActions.getDriver().manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
        if (HOLD_BROWSER_OPEN) {
            DriverActions.quit();
        }
    }

    @Given("пользователь находится на главной странице")
    public void givenOnHomePage() {
        basePage.open(URL);
    }

    @When("когда пользователь вводит регион $nameRegion и выбирает параметры для посика тура")
    public void enteringParametersTours(String nameRegion) {
        mainPage.selectingRegion(nameRegion)
                .selectingViewRecreation()
                .selectingDate();
    }

    @When("и пользователь нажимает на кнопку найти туры")
    public void clickButtonSearch() {
        mainPage.clickButtonOfSearch();
    }

    @Then("тогда пользователь видит на странице количество найденных туров")
    public void searchResults() {
        filtersForSearchPage.checkingCountTours();
    }

    @When("когда пользователь выбирает дополнительные фильтры для поиска")
    public void enteringSubParametersTours() {
        filtersForSearchPage.selectFilters();
    }

    @Then("тогда пользователь видит количество найденных туров соответствующих параметрам поиска")
    public void searchResult() {
        filtersForSearchPage.checkingCountTours();
    }

    @When("когда пользователь изменяет фильтр стоимости")
    public void changingPriceOfTour() {
        filtersForSearchPage.moveSliderPrice();
    }

    @When("когда пользователь нажимает на карточку тура")
    public void clickCardTour() {
        filtersForSearchPage.watchInfoOfTour();
    }

    @Then("тогда пользователь переходит на страницу тура")
    public void pageInfoOfTour() {
        DriverActions.switchToFrame();
        infoOfTour.checkTourPage();
    }

    @When("когда пользователь нажимает на кнопку 'Забронировать места'")
    public void clickButtonReserve() {
        infoOfTour.switchingToPageBookYourPlace();
    }

    @Then("тогда пользователь переходит на страницу с формой для заполнения данных")
    public void pageApplicationForTour() {
        applicationForTourPage.checkTitle();
    }

    @When("когда пользователь выбирает дату")
    public void enteringDate() {
        applicationForTourPage.selectingDate();
    }

    @When("и пользователь заполняет поле для ФИО")
    public void NameEntering() {
        applicationForTourPage.enteringName();
    }

    @When("и пользователь заполняет поле для номера телефона")
    public void PhoneNumberEntering() {
        applicationForTourPage.enteringPhoneNumber();
    }

    @When("и пользователь заполняет поле для почты")
    public void EmailEntering() {
        applicationForTourPage.enteringEmail();
    }

    @When("и пользователь нажимает на кнопу 'Отправить заяву'")
    public void clickButtonSend() {
        applicationForTourPage.sendApplication();
    }

    @Then("тогда пользователь видит сообщение что заявка отправлена")
    public void checkingSend() {
        applicationForTourPage.checkingErrorMessage();
    }

}
