package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.utils.Constants.Title.PageTile;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreateNewQuotePage extends BasePage {


    @FindBy(xpath = "//div[normalize-space()='Provide details of the Primary Insured']")
    private WebElement text_ProvideDetailsOfThePrimaryInsured;

    public CreateNewQuotePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void seePageTitle() {
        assertThat(driver.getTitle(), is(PageTile));
    }

    public void verifyPrimryInsuredDisplayed() {
        waitFor(2);
        verifyElementPresent(text_ProvideDetailsOfThePrimaryInsured);
    }

    public void choosePrimaryCountry(String countryName) {
        waitFor(2);
        driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();
        waitFor(2);
        driver.findElement(By.xpath("//div[@role='option']//span[contains(text(),'" + countryName + "')]")).click();

    }

    public void choosePrimaryInsured(String InsuredName) {
        waitFor(2);
        driver.findElement(By.xpath("(//div[@role='option'])[9]")).click();
        waitFor(2);
        driver.findElement(By.xpath("//div[@role='option']//span[contains(text(),'" + InsuredName + "')]")).click();

    }


    public void clickClassOfBusinessCheckBox(String className) {
        waitFor(2);
        driver.findElement(By.xpath("//div[@aria-label='" + className + "']/div/div[1]")).click();

    }

    public void verifyCoverageRequiredPageDisplayed() {
        waitFor(2);
        driver.findElement(By.xpath("//div[normalize-space()='Provide details of the coverage required']")).click();

    }

    public void ChooseInceptionDate() {
        waitFor(2);
        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("2021-12-12");
    }

    public void enterAVMValue() {
        waitFor(2);
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("123");
    }

    public void enterPremiumValue() {
        waitFor(2);
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("122");
    }

}
