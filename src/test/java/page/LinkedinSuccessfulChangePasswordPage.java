package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccessfulChangePasswordPage extends LinkedinBasePage{

    /**
     * Find WebElment successfullChangeMessage
     */
    @FindBy(xpath = "//*[@class= 'flow-login-content']")
    //"//div"
    private WebElement successfullChangeMessage;

    public LinkedinSuccessfulChangePasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Is the element loaded or not?
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isLoaded() {
        boolean isLoaded;
        try {
            isLoaded = successfullChangeMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            isLoaded = false;
        }
        return isLoaded;
    }
}
