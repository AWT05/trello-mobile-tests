package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Board extends PageObject {

    private final static String BOARD_TITLE = "com.trello:id/toolbar_title";
    private final static String CLOSE_BUTTON_XPATH = "//android.widget.ImageButton[@content-desc='Close']";

    @FindBy(id = BOARD_TITLE)
    private MobileElement boardTitle;

    @FindBy(xpath = CLOSE_BUTTON_XPATH)
    private MobileElement backButton;

    public Board(WebDriver driver) {
        super(driver);
    }

    public String getBoardTitle() {
        return boardTitle.getText();
    }
    public void closeBoard() {
        wait.until(ExpectedConditions.visibilityOf(backButton));
        backButton.click();
    }
}
