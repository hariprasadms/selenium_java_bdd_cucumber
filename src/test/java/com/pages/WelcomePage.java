package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static com.utils.Constants.Title.PageTile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//span[@class='freebirdFormviewerComponentsQuestionBaseErrorText']")
    private WebElement msg_ThisIsaRequiredQuestion;

    @FindBy(xpath = "//span[normalize-space()='See my pending quotes']")
    private WebElement pendingQuotesCheckBox;


    @FindBy(xpath = "//span[normalize-space()='Create a new quote']")
    private WebElement createNewQuoteCheckBox;

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void verifyMandatoryMsgdisplayed() {
        verifyElementPresent(msg_ThisIsaRequiredQuestion);
    }

    public void verifyPendingQuotesCheckBoxdisplayed() {
        waitFor();
        verifyElementPresent(pendingQuotesCheckBox);
    }

    public void clickPendingQuotesCheckBox() {
        waitFor();
        pendingQuotesCheckBox.click();
    }

    public void verifyCreateNewQuoteCheckBoxdisplayed() {
        waitFor();
        verifyElementPresent(createNewQuoteCheckBox);
    }

    public void clickCreateQuotesCheckBox() {
        waitFor();
        createNewQuoteCheckBox.click();
    }
}

