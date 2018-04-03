package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.LinkedinBasePage;

public class LinkedinLoginPage extends LinkedinBasePage{

    /**
     * Find WebElment emailField
     */
    @FindBy(id = "session_key-login")
    private WebElement emailField;

    /**
     * Find WebElment passwordField
     */
    @FindBy(id = "session_password-login")
    private WebElement passwordField;

    /**
     * Find WebElment signInButton
     */
    @FindBy(id = "btn-primary")
    private WebElement signInButton;

    /**
     * Find WebElment alertError
     */
    @FindBy(id = "global-alert-queue")
    private WebElement alertError;


    public LinkedinLoginPage(WebDriver driver) {
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
     * Is the element displayed or not?
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isNotSignedIn() {
        return alertError.isDisplayed();
    }
}