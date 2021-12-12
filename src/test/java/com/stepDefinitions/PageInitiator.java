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
        iAtWelcomPage = new WelcomePage(driverManager.getDriver());
        iPendingQuotesPage = new PendingQuotesPage(driverManager.getDriver());
        iCreateNewQuotePage = new CreateNewQuotePage(driverManager.getDriver());
    }

}
