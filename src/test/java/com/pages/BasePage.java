package com.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    private static BasePage instance;
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final int PAGE_LOAD_TIMEOUT = 10;
    private static final int IMPLICIT_WAIT = 10;
    private static final int EXPLICIT_WAIT = 20;

    @FindBy(className = "page-title")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[@title='Accept Cookies']")
    private List<WebElement> acceptCookiesButtons;

    BasePage() {
        initializeWebDriver();
    }

    public static synchronized BasePage getInstance() {
        if (instance == null) {
            instance = new BasePage() {};
        }
        return instance;
    }

    private void initializeWebDriver() {
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

            PageFactory.initElements(driver, this);

            wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }
    }

    protected String getPageTitle() {
        return pageTitle.getText().trim();
    }

    protected void acceptCookies() {
        List<WebElement> cookieButtons = waitForAllElements(acceptCookiesButtons);
        if (!cookieButtons.isEmpty()) {
            waitFor();
            waitForElementToBeClickable(cookieButtons.get(0)).click();
        }
    }

    protected void waitFor() {
        try {
            Thread.sleep((long) 2 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during wait", e);
        }
    }

    protected boolean isElementPresent(WebElement parentElement, String childXpath) {
        try {
            return parentElement.findElement(By.xpath(childXpath)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void verifyElementPresent(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println(element + " element is present");
        } else {
            throw new NoSuchElementException(element + " Element not found");
        }
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected List<WebElement> waitForAllElements(List<WebElement> elementList) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            instance = null;
        }
    }
}