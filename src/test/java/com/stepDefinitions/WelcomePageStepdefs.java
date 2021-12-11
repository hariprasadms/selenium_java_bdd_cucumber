package com.stepDefinitions;

import com.drivers.DriverManager;
import com.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

public class WelcomePageStepdefs {

    private final DriverManager driverManager = new DriverManager();
    private final WelcomePage iAtWelcomPage = new WelcomePage(driverManager.getDriver());

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
}
