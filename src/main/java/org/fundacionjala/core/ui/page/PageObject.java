package org.fundacionjala.core.ui.page;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    private static final int SECONDS = 20;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, SECONDS);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
