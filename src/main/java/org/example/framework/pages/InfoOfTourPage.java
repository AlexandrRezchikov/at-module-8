package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.asserts.AssertsElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InfoOfTourPage extends BasePage {

    @FindBy(xpath = "//div[@class='tour-sidebar']//button[contains(., 'Забронировать места')]")
    private WebElement buttonReserve;

    @FindBy(xpath = "//aside[@class='tour-content__aside']//strong[@class='sidebar-resume__price-value']")
    private WebElement price;

    @FindBy(xpath = "//section[@id='browse']//p")
    private WebElement description;

    @FindBy(xpath = "//div[@class='tour-header__content']/h1[@class='tour-header__title']")
    private WebElement tourName;

    @Step("Переход на страницу бронирования тура")
    public InfoOfTourPage switchingToPageBookYourPlace() {
        Assert.assertTrue(buttonReserve.isDisplayed(), "Button number of tours is not displayed");
        buttonReserve.click();
        return this;
    }

    @Step("проверка страницы тура")
    public InfoOfTourPage checkTourPage() {
        AssertsElements.checkVisible(buttonReserve);
        return this;
    }

}
