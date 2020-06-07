package org.fundacionjala.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    public PageObject(final WebDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }
}
