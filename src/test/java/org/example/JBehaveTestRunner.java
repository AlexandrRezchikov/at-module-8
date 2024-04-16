package org.example;


import io.qameta.allure.Allure;
import org.example.framework.common.DriverActions;
import org.example.framework.pages.AllPages;
import org.example.framework.steps.BaseStepDefinitions;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Properties;

import static org.example.framework.config.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.example.framework.config.Config.HOLD_BROWSER_OPEN;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class JBehaveTestRunner extends ConfigurableEmbedder {

    public Embedder embedder;
    public WebDriver driver;

    @Override
    @Test
    public void run() {
        embedder = configuredEmbedder();
        embedder.configuration();
        embedder.runStoriesAsPaths(storyPaths());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BaseStepDefinitions());
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
                .useStoryReporterBuilder(createStoryReporterBuilder());
    }

    private StoryReporterBuilder createStoryReporterBuilder() {
        return new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(this.getClass()))
                .withDefaultFormats()
                .withFormats(Format.CONSOLE, Format.HTML)
                .withViewResources(properties())
                .withFailureTrace(true);
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("decorateNonHtml", "true");
        return properties;
    }

    public List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
                "**/*.story", "");
    }

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
}