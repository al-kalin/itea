package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GMailService;

public class LinkedinPasswordResetSubmitPage extends LinkedinBasePage{

    /**
     * Find WebElment resentButtonLink
     */
    @FindBy (xpath = "//a[@class='status-link btn-resend-link']")
    private WebElement resentButtonLink;

    public LinkedinPasswordResetSubmitPage(WebDriver driver) {
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
            isLoaded = resentButtonLink.isDisplayed();
        }
        catch (NoSuchElementException e){
            isLoaded = false;
        }
        return  isLoaded;
    }

    public LinkedinResetPasswordPage navigateToResetPasswordLink(String ressetPasswordLink){
        driver.get(ressetPasswordLink);
        return new LinkedinResetPasswordPage(driver);
    }

    /**
     * contact with gmail service and get massage for change password
     * @param messageToPartial - ???
     * @return link for change password
     */
    public String getResetPasswordLinkFromEmail(String messageToPartial) {
        String messageSubjectPartial = "here's the link to reset your password";
        String messageFromPartial = "security-noreply@linkedin.com";
        utils.GMailService GMailService = new GMailService();
        String message = GMailService.waitForNewMessage(messageSubjectPartial, messageToPartial, messageFromPartial, 60);

        String resetPasswordLink = StringUtils.substringBetween(message, "browser:", "This link").trim();
        return resetPasswordLink;
    }
}

