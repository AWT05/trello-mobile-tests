package org.fundacionjala.Pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(messageButton));
        } catch (TimeoutException e) {
            return false;
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
