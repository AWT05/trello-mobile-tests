package org.fundacionjala.Pages.login;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class LoginCredentials extends PageObject {

    private static final String USER_FIELD = "com.trello:id/user";
    private static final String AUTH_BUTTON = "com.trello:id/authenticate";
    private static final String PASSWORD_FIELD = "com.trello:id/password";

    @AndroidFindBy(id = USER_FIELD)
    private MobileElement userField;

    @AndroidFindBy(id = AUTH_BUTTON)
    private MobileElement authButton;

    @AndroidFindBy(id = PASSWORD_FIELD)
    private MobileElement passwordField;

    public LoginCredentials(final WebDriver driver) {
        super(driver);
    }

    public LoginCredentials setUserName(final String userName) {
        wait.until(ExpectedConditions.visibilityOf(userField));
        userField.clear();
        userField.sendKeys(userName);
        authButton.click();
        return this;
    }

    public void setPassword(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        authButton.click();
    }
}
