import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinLoginPage extends LinkedinBasePage{
    WebDriver driver;

    public LinkedinLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signInButton;

    private void initelEments() {
        emailField = driver.findElement(By.id("login-email"));
        waitUntilElementIsClickable(emailField, 5);
        passwordField = driver.findElement(By.id("login-password"));
        signInButton = driver.findElement(By.id("login-submit"));
    }

    public LinkedinBasePage loginAs(String email, String password) {
        initelEments();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return new LinkedinBasePage(driver);
    }
}