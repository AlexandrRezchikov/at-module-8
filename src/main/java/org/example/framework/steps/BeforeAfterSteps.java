package org.example.framework.steps;

import io.qameta.allure.Allure;
import org.example.framework.common.DriverActions;
import org.example.framework.pages.AllPages;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static org.example.framework.config.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.example.framework.config.Config.HOLD_BROWSER_OPEN;

public class BeforeAfterSteps {

    @BeforeStory
    public void setUp() {
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

}
