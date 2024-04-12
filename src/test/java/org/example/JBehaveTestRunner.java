package org.example;


import org.example.framework.steps.Steps;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class JBehaveTestRunner extends ConfigurableEmbedder {

    public  Embedder embedder;

    @Override
    @Test
    public void run() {
        embedder = configuredEmbedder();
        embedder.configuration();
        embedder.runStoriesAsPaths(storyPaths());
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(), new Steps());
    }

    @Override
    public Configuration configuration(){
        return  new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(getClass().getClassLoader()))
                .useStoryReporterBuilder(createStoryReporterBuilder());
    }

    private StoryReporterBuilder createStoryReporterBuilder(){
        return new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(this.getClass()))
                .withDefaultFormats()
                .withFormats(Format.CONSOLE, Format.HTML)
                .withViewResources(properties())
                .withFailureTrace(true);
    }

    private Properties properties(){
        Properties properties = new Properties();
        properties.setProperty("decorateNonHtml", "true");
        return properties;
    }

    public List<String> storyPaths(){
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()),
                "**/*.story", "");
    }
}