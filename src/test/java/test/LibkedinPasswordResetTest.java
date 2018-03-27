package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinRequestPasswordResetPage;
import page.LinkedinPasswordResetSubmitPage;
import page.LinkedinResetPasswordPage;
import page.LinkedinSuccessfulChangePasswordPage;
import utils.GMailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class LibkedinPasswordResetTest extends LinkedinBaseTest{

    String userEmail = "alkalin.qa@gmail.com";
    String newPassword = "newPassword";

    @Test
    public void successfulPasswordReset() {
        LinkedinRequestPasswordResetPage reqestPasswordResetPage = landingPage.forgotPaswordLinkClick();
        Assert.assertTrue(reqestPasswordResetPage.isLoaded(), "requestPasswordResetPage is not loaded");

        LinkedinPasswordResetSubmitPage passwordResetSubmitPage = reqestPasswordResetPage.submitEmail(userEmail);
        Assert.assertTrue(passwordResetSubmitPage.isLoaded(), "passwordResetSubmitPage is not loaded");

        String messageSubjectPartial = "here's the link to reset your password";
        String messageToPartial = "alkalin.qa@gmail.com";
        String messageFromPartial = "security-noreply@linkedin.com";

        GMailService GMailService = new GMailService();
        String message = GMailService.waitForNewMessage(messageSubjectPartial, messageToPartial, messageFromPartial, 60);

        System.out.println("Content: " + message);

        //https://www.linkedin.com/e/rpp/639069381/alkalin%2Eqa%40gmail%2Ecom/1875808516860349911/?hs=true&tok=2cKYSU9RLc6oc1

        private static final Pattern urlPattern = Pattern.compile(
                "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                        + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

        Matcher matcher = urlPattern.matcher(message);
        while (matcher.find()) {
            int matchStart = matcher.start(1);
            int matchEnd = matcher.end();
            // now you have the offsets of a URL match
        }

        LinkedinResetPasswordPage resetPasswordPage = new LinkedinResetPasswordPage(driver);
        Assert.assertTrue(resetPasswordPage.isLoaded(), "resetPasswordPage is not loaded");

        LinkedinSuccessfulChangePasswordPage successfulChangePasswordPage = resetPasswordPage.changePassword(String, "newPassword");
        Assert.assertTrue(successfulChangePasswordPage.isLoaded(), "successfulChangePasswordPage is not loaded");

    }
}
