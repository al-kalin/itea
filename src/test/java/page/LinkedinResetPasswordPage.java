package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinResetPasswordPage extends LinkedinBasePage{

    @FindBy(id = "new_password-newPassword-passwordReset")
    private WebElement newPasswordField;

    @FindBy (id = "new_password_again-newPassword-passwordReset")
    private WebElement NewPasswordAgainField;

    @FindBy (id = "reset")
    private WebElement submitButton;

    public LinkedinResetPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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

    public LinkedinSuccessfulChangePasswordPage changePassword(String newPassword) {
        newPasswordField.sendKeys(newPassword);
        NewPasswordAgainField.sendKeys(newPassword);
        submitButton.click();
        return new LinkedinSuccessfulChangePasswordPage(driver);
    }
}
