package org.example.framework.asserts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.example.framework.common.DriverActions.getDriver;

public class AssertsElements {

    public static void checkVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), String.format("Element '%s' is not displayed", element.getAccessibleName()));
    }

    public static void equalsInteger(int integer, int i) {
        Assert.assertEquals(integer, i, " количество не равно!");
    }

    public static void checkError(String text) {
        getDriver().findElement(By.xpath(String.format("//*[contains(., '%s')]", text)));
        //...
        //+ добавь проверку цвета ошибки
    }

    public static void checkError(By by) {
        getDriver().findElement(by);
        //...
    }
}
