package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public final class Login extends PageObject {
    private final static String PRIMARY_CREDENTIAL = "com.google.android.gms:id/credential_primary_label";

    @AndroidFindBy(id = PRIMARY_CREDENTIAL)
    private MobileElement primarySmartlockCredential;

    public Login(final WebDriver driver) {
        super(driver);
    }

    public void loginWithSmartLock() {
        primarySmartlockCredential.click();
    }
}
