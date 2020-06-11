package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import org.fundacionjala.Pages.list.ListForm;
import org.fundacionjala.core.ui.form.FormPage;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class Board extends PageObject {

    private static final String BOARD_TITLE = "com.trello:id/toolbar_title";
    private static final String CLOSE_BUTTON_XPATH = "//android.widget.ImageButton[@content-desc]";
    private static final String CREATE_NEW_LIST = "com.trello:id/add_list_button";
    private static final String PANEL_BOARD = "//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView";

    @FindBy(id = BOARD_TITLE)
    private MobileElement boardTitle;

    @FindBy(xpath = CLOSE_BUTTON_XPATH)
    private MobileElement backButton;

    @FindBy(id = CREATE_NEW_LIST)
    private MobileElement createNewList;

    @FindBy(xpath = PANEL_BOARD)
    private MobileElement panelBoard;

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

    public FormPage<?> createNewList() {
        while (!actions.isElementDisplayed(createNewList)) {
            actions.SwipeScreenRight(panelBoard);
        }
        createNewList.click();
        return new ListForm(driver);
    }
}
