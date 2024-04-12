package org.example.framework.asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertsElements {

    public static void checkVisible(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), String.format("Element '%s' is not displayed", element.getAccessibleName()));
    }

    public static void equalsInteger(int integer, int i) {
        Assert.assertEquals(integer, i, " количество не равно!");
    }
}
