package org.example.framework.pages;

public class AllPages {

    protected static BasePage basePage;
    protected static MainPage mainPage;
    protected static FiltersForSearchPage filtersForSearchPage;
    protected static InfoOfTourPage infoOfTour;
    protected static ApplicationForTourPage applicationForTourPage;

    public static void init() {

        basePage = new BasePage();
        mainPage = new MainPage();
        filtersForSearchPage = new FiltersForSearchPage();
        infoOfTour = new InfoOfTourPage();
        applicationForTourPage = new ApplicationForTourPage();
    }
}
