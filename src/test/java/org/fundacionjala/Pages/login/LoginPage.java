package org.fundacionjala.Pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public final class LoginPage extends PageObject {

    private static final String MESSAGE_BUTTON = "android:id/button1";
    private static final String LOGIN_BUTTON = "com.trello:id/log_in_button";

    @AndroidFindBy(id = MESSAGE_BUTTON)
    private MobileElement messageButton;

    @AndroidFindBy(id = LOGIN_BUTTON)
    private MobileElement loginButton;

    public LoginPage(final WebDriver driver) {
        super(driver);
    }

    public Boolean skippLogin() {
        Environment env = Environment.getInstance();
        try {
            wait.withTimeout(env.getReducedTime(), TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(messageButton));

        } catch (TimeoutException e) {
            return false;
        }
        finally {
            wait.withTimeout(env.getExplicitTimeWait(), TimeUnit.SECONDS);
        }
        return true;
    }

    public LoginPage acceptMessage() {
        messageButton.click();
        return this;
    }

    public LoginCredentials pressLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginCredentials(driver);
    }
}
