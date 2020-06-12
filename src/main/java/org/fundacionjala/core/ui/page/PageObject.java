package org.fundacionjala.core.ui.page;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.fundacionjala.core.ui.config.Environment;
import org.fundacionjala.core.ui.driver.DriverActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected DriverActions actions;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Environment.getInstance().getExplicitTimeWait());
        actions = new DriverActions(driver, wait);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
