import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage {
    WebDriver driver;

    public LinkedinLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;

    private void initelements() {
        emailField = driver.findElement(By.id("login-email"));
        waitUntilElementIsClickable(emailField, 5);
        passwordField = driver.findElement(By.id("login-password"));
        signInButton = driver.findElement(By.id("login-submit"));
    }

    public void loginAs(String email, String password) {
        initelements();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

    public void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementIsClickable(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}