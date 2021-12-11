package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.utils.Constants.Title.PageTile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//span[@class='freebirdFormviewerComponentsQuestionBaseErrorText']")
    private WebElement msg_ThisIsaRequiredQuestion;

    @FindBy(xpath = "//span[normalize-space()='See my pending quotes']")
    private WebElement pendingQuotesCheckBox;


    @FindBy(xpath = "//span[normalize-space()='Create a new quote']")
    private WebElement createNewQuoteCheckBox;


    @Override
    public void seePageTitle() {
        assertThat(driver.getTitle(), is(PageTile));
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void verifyMandatoryMsgdisplayed() {
        verifyElementPresent(msg_ThisIsaRequiredQuestion);
    }

    public void verifyPendingQuotesCheckBoxdisplayed() {
        waitFor(2);
        verifyElementPresent(pendingQuotesCheckBox);
    }

    public void verifyCreateNewQuoteCheckBoxdisplayed() {
        waitFor(2);
        verifyElementPresent(createNewQuoteCheckBox);
    }
}

