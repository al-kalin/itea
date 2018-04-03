package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

public class LinkedinLandingPage extends LinkedinBasePage{

    /**
     * Find WebElment emailField
     */
    @FindBy(id = "login-email")
    private WebElement emailField;

    /**
     * Find WebElment passwordField
     */
    @FindBy(id = "login-password")
    private WebElement passwordField;

    /**
     * Find WebElment passwordField
     */
    @FindBy(id = "login-submit")
    private WebElement signInButton;

    /**
     * Find WebElment forgotPaswordLink
     */
    @FindBy(xpath = "//*[@class ='link-forgot-password']")
    private WebElement forgotPaswordLink;

    public LinkedinLandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Is the element loaded or not?
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isLoaded(){
        boolean isLoaded;
        try {
            isLoaded = signInButton.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return  isLoaded;
    }

    /**
     * Click to the link Forgot Password
     * @return new page LinkedinRequestPasswordResetPage
     */
    public LinkedinRequestPasswordResetPage forgotPaswordLinkClick(){
        forgotPaswordLink.click();
    return new LinkedinRequestPasswordResetPage(driver);
    }

    /**
     * Enter email and password and verifies. Navigated to new web page
     * @param email - user email to login
     * @param password - user password to login
     * @param <T> - generic type
     * @return new web page LinkedinHomePage or LinkedinLoginPage
     */
    public <T> T loginAs(String email, String password) {
        waitUntilElementIsClickable(emailField, 5);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getPageUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(driver);
        }
        if (getPageUrl().contains("/login-submit")) {
            return (T) new LinkedinLoginPage(driver);
        }
        else {
            return (T) this;
        }
    }
}
