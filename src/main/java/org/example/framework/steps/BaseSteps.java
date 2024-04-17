package org.example.framework.steps;

import org.example.framework.pages.AllPages;

import org.jbehave.core.annotations.Given;

import static org.example.framework.config.Config.*;

public class BaseSteps extends AllPages {

    @Given("пользователь переходит на сайт")
    public void userGoesToSite() {
        basePage.open(URL);
        mainPage.checkTitle();
    }

}
