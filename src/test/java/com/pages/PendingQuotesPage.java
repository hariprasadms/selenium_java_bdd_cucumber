package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.utils.Constants.Title.PageTile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PendingQuotesPage extends BasePage {

    public PendingQuotesPage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextButton;


    @FindBy(xpath = "//div[@class='freebirdMaterialHeaderbannerPagebreakText freebirdFormviewerViewItemsPagebreakBannerText freebirdCustomFont']")
    private WebElement pendingQuotesPageTitle;

    @FindBy(xpath = "//span[normalize-space()='Create a new quote']")
    private WebElement createNewQuoteCheckBox;

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void verifyPendingQuotesPageText() {
        waitFor();
        verifyElementPresent(pendingQuotesPageTitle);
    }

    public void verifyPendingQuotes(List<String> pendingQuotesNames) {
        waitFor();
        for (String pendingQuotesName : pendingQuotesNames) {
            driver.findElement(By.xpath("//div[normalize-space()='" + pendingQuotesName + "']")).isDisplayed();
        }

    }
}

