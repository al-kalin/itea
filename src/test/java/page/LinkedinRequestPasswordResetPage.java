package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage{

    /**
     * Find WebElment userNameField
     */
    @FindBy (xpath = "//input [@name = 'userName']")
    private WebElement userNameField;

    /**
     * Find WebElment submitButton
     */
    @FindBy (xpath = "//input [@name = 'request']")
    private WebElement submitButton;

    public LinkedinRequestPasswordResetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Enter email to change password
     * @param userEmail - email to change password
     * @return new web page LinkedinPasswordResetSubmitPage
     */
    public LinkedinPasswordResetSubmitPage submitEmail(String userEmail) {
        userNameField.sendKeys(userEmail);
        submitButton.click();
        return new LinkedinPasswordResetSubmitPage(driver);
    }

    /**
     * Is the element loaded or not?
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isLoaded(){
        boolean isLoaded;
        try {
            isLoaded = userNameField.isDisplayed();
        }
        catch (NoSuchElementException e){
          isLoaded = false;
        }
        return  isLoaded;
    }
}
