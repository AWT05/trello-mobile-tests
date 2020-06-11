package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.fundacionjala.Pages.list.ListForm;
import org.fundacionjala.core.ui.form.FormPage;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

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
        /*while (!createNewList.isDisplayed()){
            SwipeScreen(panelBoard, driver);
        }*/
        SwipeScreen(panelBoard, driver);
        SwipeScreen(panelBoard, driver);
        SwipeScreen(panelBoard, driver);
        createNewList.click();
        return new ListForm(driver);
    }

    public void SwipeScreen(WebElement element, WebDriver driver) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Dimension dimension = element.getSize();
        int Anchor = element.getSize().getHeight() / 2;
        int scrollStart = (int) (dimension.getWidth() * 0.8);
        int scrollEnd = (int) (dimension.getWidth() * 0.2);
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(scrollStart, Anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(scrollEnd, Anchor))
                .release().perform();
    }
}
