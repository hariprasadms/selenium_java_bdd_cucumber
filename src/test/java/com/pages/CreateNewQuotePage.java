package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewQuotePage extends BasePage {

    @FindBy(xpath = "//div[normalize-space()='Provide details of the Primary Insured']")
    private WebElement textProvideDetailsOfThePrimaryInsured;

    @FindBy(xpath = "//div[normalize-space()='Provide details of the coverage required']")
    private WebElement textProvideDetailsOfCoverageRequired;

    @FindBy(xpath = "//input[@type='date']")
    private WebElement inceptionDateInput;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    private WebElement avmValueInput;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement premiumValueInput;

    public CreateNewQuotePage(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
    }


    public void verifyPrimaryInsuredDisplayed() {
        waitFor();
        verifyElementPresent(textProvideDetailsOfThePrimaryInsured);
    }

    public void choosePrimaryCountry(String countryName) {
        waitFor();
        driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();
        waitFor();
        driver.findElement(By.xpath("//div[@role='option']//span[contains(text(),'" + countryName + "')]")).click();
    }

    public void choosePrimaryInsured(String insuredName) {
        waitFor();
        getDriver().findElement(By.xpath("(//div[@role='option'])[9]")).click();
        waitFor();
        getDriver().findElement(By.xpath("//div[@role='option']//span[contains(text(),'" + insuredName + "')]")).click();
    }

    public void clickClassOfBusinessCheckBox(String className) {
        waitFor();
        getDriver().findElement(By.xpath("//div[@aria-label='" + className + "']/div/div[1]")).click();
    }

    public void verifyCoverageRequiredPageDisplayed() {
        waitFor();
        verifyElementPresent(textProvideDetailsOfCoverageRequired);
    }

    public void chooseInceptionDate(String date) {
        waitFor();
        inceptionDateInput.sendKeys(date);
    }

    public void enterAVMValue(String value) {
        waitFor();
        avmValueInput.sendKeys(value);
    }

    public void enterPremiumValue(String value) {
        waitFor();
        premiumValueInput.sendKeys(value);
    }

    public void ChooseInceptionDate() {
    }

    public void verifyPrimryInsuredDisplayed() {
    }
}