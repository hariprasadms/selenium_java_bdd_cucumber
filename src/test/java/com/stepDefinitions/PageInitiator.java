package com.stepDefinitions;

import com.drivers.DriverManager;
import com.pages.BasePage;
import com.pages.CreateNewQuotePage;
import com.pages.PendingQuotesPage;
import com.pages.WelcomePage;

public class PageInitiator {
    public final DriverManager driverManager;
    public final WelcomePage iAtWelcomPage;
    public final PendingQuotesPage iPendingQuotesPage;
    public final CreateNewQuotePage iCreateNewQuotePage;

    public PageInitiator() {


        driverManager = new DriverManager();
        iAtWelcomPage = new WelcomePage(BasePage.getInstance().getDriver());
        iPendingQuotesPage = new PendingQuotesPage(BasePage.getInstance().getDriver());
        iCreateNewQuotePage = new CreateNewQuotePage(BasePage.getInstance().getDriver());
    }

}
