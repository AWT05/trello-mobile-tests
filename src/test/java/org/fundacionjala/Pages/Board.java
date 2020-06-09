package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Board extends PageObject {

    private final static String BOARD_TITLE = "com.trello:id/toolbar_title";

    @FindBy(id = BOARD_TITLE)
    private MobileElement boardTitle;

    public Board(WebDriver driver) {
        super(driver);
    }

    public String getBoardTitle() {
        return boardTitle.getText();
    }


}
