package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinResetPasswordPage extends LinkedinBasePage{

    /**
     * Find WebElment newPasswordField
     */
    @FindBy(id = "new_password-newPassword-passwordReset")
    private WebElement newPasswordField;

    /**
     * Find WebElment NewPasswordAgainField
     */
    @FindBy (id = "new_password_again-newPassword-passwordReset")
    private WebElement NewPasswordAgainField;

    /**
     * Find WebElment submitButton
     */
    @FindBy (id = "reset")
    private WebElement submitButton;

    public LinkedinResetPasswordPage(WebDriver driver) {
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
            isLoaded = newPasswordField.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return  isLoaded;
    }

    /**
     * Enter new password to change old password
     * @param newPassword - new password
     * @return new web page LinkedinSuccessfulChangePasswordPage
     */
    public LinkedinSuccessfulChangePasswordPage changePassword(String newPassword) {
        newPasswordField.sendKeys(newPassword);
        NewPasswordAgainField.sendKeys(newPassword);
        waitUntilElementIsClickable(submitButton).click();
        return new LinkedinSuccessfulChangePasswordPage(driver);
    }
}
