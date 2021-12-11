package com.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KiStepdefs extends PageInitiator {


    @After
    public void quit() {
        if (Objects.nonNull(driverManager.getDriver())) driverManager.getDriver().quit();
    }

    @Given("I can launch browser and navigate welcome page")
    public void iCanLaunchBrowserAndNavigateWelcomePage() {
        driverManager.launchApplication();
    }

    @Then("I see welcome page loaded with see my pending quotes and create new quotes")
    public void iSeeWelcomePageLoaded() {
        iAtWelcomPage.seePageTitle();
    }


    @When("I click on next button, i see mandatory validation message")
    public void iClickOnNextButtonISeeMandatoryValidationMessage() {
        iAtWelcomPage.clickOnNextButton();
        iAtWelcomPage.verifyMandatoryMsgdisplayed();
    }

    @Then("I can see see my pending quotes checkbox")
    public void iCanSeeSeeMyPendingQuotesCheckbox() throws InterruptedException {
        iAtWelcomPage.verifyPendingQuotesCheckBoxdisplayed();
    }

    @And("I can see my create new quote checkbox")
    public void iCanSeeSeeMyCreateNewQuoteCheckbox() {
        iAtWelcomPage.verifyCreateNewQuoteCheckBoxdisplayed();
    }

    @When("I can select see my pending quotes checkbox")
    public void iCanSelectSeeMyPendingQuotesCheckbox() {
        iAtWelcomPage.clickPendingQuotesCheckBox();
    }

    @And("click on next button")
    public void clickOnNextButton() {
        iAtWelcomPage.clickOnNextButton();
    }

    @Then("I can see pending quotes page displayed")
    public void iCanSeePendingQuotesPageDisplayed() {
        iPendingQuotesPage.seePageTitle();
        iPendingQuotesPage.verifyPendingQuotesPageText();
    }

    @And("I can see quote details")
    public void iCanSeeQuoteDetails() {
        List<String> pendingQuoteNames = new ArrayList<>();
        pendingQuoteNames.add("Service Tech Ltd");
        pendingQuoteNames.add("Logistics Worldwide Inc");
        pendingQuoteNames.add("XYZ Holdings PLC");
        iPendingQuotesPage.verifyPendingQuotes(pendingQuoteNames);
    }
}
