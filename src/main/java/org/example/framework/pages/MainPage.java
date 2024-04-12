package org.example.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Введите регион, место или тур' and @name='search']")
    private WebElement textBarRegion;

    @FindBy(css = ".search-autocomplete-group__item")
    private WebElement searchResultRegion;

    @FindBy(xpath = "//input[@placeholder='Любой']")
    private WebElement textBarVieRecreation;

    @FindBy(xpath = "//li[@data-id='15' and @data-type='rest_kinds']")
    private WebElement viewRecreation;

    @FindBy(xpath = "//input[@placeholder='Любые']")
    private WebElement textBarDate;

    @FindBy(xpath = ".//button[contains(., 'Майские праздники')]")
    private WebElement tourDates;

    @FindBy(xpath = ".//button[contains(., 'Найти туры')]")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//div[@class='dayContainer']/span[@aria-label='Март 22, 2024']")
    private WebElement firstDateTour;

    @FindBy(xpath = ".//div[@class='dayContainer']/span[@aria-label='Март 25, 2024']")
    private WebElement secondDateTour;

    @FindBy(css = ".app-header #tours-link")
    private WebElement headerTours;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/regiony']")
    private WebElement headerRegions;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/aviabilety']")
    private WebElement headerAirTickets;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/korporativnye-tury-po-rossii']")
    private WebElement headerCorporateTours;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/o-kompanii']")
    private WebElement headerAboutUs;

    @FindBy(xpath = "//header[@class='app-header']//a[@href='/kontakty']")
    private WebElement headerContacts;

    @FindBy(css = "#header-call-request .as-button__body")
    private WebElement headerButtonRequestCall;


    public MainPage checkTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Большая Страна — Все туры по России"));
        return this;
    }

    @Step("Выбор региона для поиска")
    public MainPage selectingRegion(String value) {
        textBarRegion.click();
        textBarRegion.sendKeys(value);
        searchResultRegion.click();
        return this;
    }

    @Step("Выбор вида отдыха")
    public MainPage selectingViewRecreation() {
        textBarVieRecreation.click();
        waitElementIsVisible(viewRecreation).click();
        return this;
    }

    @Step("Выбор даты для тура")
    public MainPage selectingDate() {
        textBarDate.click();
        waitElementIsVisible(tourDates).click();
        return this;
    }

    @Step("Нажатие кнопки поиска")
    public MainPage clickButtonOfSearch() {
        waitElementIsVisible(buttonSearch).click();
        return this;
    }

}
