package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LinkedinBasePage {
    WebDriver driver;

    /**
     * Constructor of LinkedinBasePage class which takes WebDriver instance initialized in @BeforMethod
     * for reuse in LinkedinBasePage class methods
     * @param driver - WebDriver instance
     */
    public LinkedinBasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to Wait for
     * @return WebElement after wait
     */
    public WebElement waitUntilElementIsClickable(WebElement webElement) {
        waitUntilElementIsClickable(webElement, 10);
        return webElement;
    }

    /**
     * Wait until WebElement is Clickable on Web page
     * @param webElement - WebElement to Wait for
     * @param timeOutInSeconds - time to wait
     * @return WebElement after wait
     */
    public WebElement waitUntilElementIsClickable(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    /**
     * Wait until WebElement is Visible on Web page
     * @param webElement - WebElement to Wait for
     * @param timeOutInSeconds - time to wait
     */
    public void waitUntilELementIsVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public abstract boolean isLoaded();
}