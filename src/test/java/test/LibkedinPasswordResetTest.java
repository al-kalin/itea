package test;

import org.apache.commons.lang3.StringUtils;
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

        String resetPasswordLink = passwordResetSubmitPage.getResetPasswordLinkFromEmail(userEmail);
        //entering capcha manually

        LinkedinResetPasswordPage resetPasswordPage = passwordResetSubmitPage.navigateToResetPasswordLink(resetPasswordLink);
        Assert.assertTrue(resetPasswordPage.isLoaded(), "resetPasswordPage is not loaded");

        LinkedinSuccessfulChangePasswordPage successfulChangePasswordPage = resetPasswordPage.changePassword(newPassword);
        Assert.assertTrue(successfulChangePasswordPage.isLoaded(), "successfulChangePasswordPage is not loaded");

    }
}
