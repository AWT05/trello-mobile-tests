package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.fundacionjala.core.ui.page.PageObject;

import java.util.List;

public final class Home extends PageObject {

    private static final String BOARD_EN = "Boards";
    private static final String ADD_BUTTON = "com.trello:id/add_fab";
    private static final String ADD_BOARD_BUTTON = "com.trello:id/add_board_fab";
    private static final String BOARD_NAME_FIELD = "com.trello:id/board_name";
    private static final String TEAM_DROPDOWN = "com.trello:id/team_spinner";
    private static final String LIST_OF_TEAMS_XPATH = "//android.widget.ListView/android.view.ViewGroup";
    private static final String CREATE_BUTTON = "com.trello:id/create_board";
    private static final String OPEN_SIDE_DRAWER_XPATH = "//android.widget.ImageButton[@content-desc='Open Drawer']";
    private static final String HEADER_NAME_XPATH = "//android.widget.LinearLayout/android.view.ViewGroup/"
            + "android.widget.TextView";
    private static final String SIDE_DRAWER_BOARDS_XPATH = "/hierarchy/android.widget.FrameLayout/android"
            + ".widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget."
            + "FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx."
            + "recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView";
    private static final String AVAILABLE_BOARDS_XPATH = "//androidx.recyclerview.widget.RecyclerView/"
            + "android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";

    @AndroidFindBy(id = ADD_BUTTON)
    private MobileElement addButton;

    @AndroidFindBy(id = ADD_BOARD_BUTTON)
    private MobileElement addBoardButton;

    @AndroidFindBy(id = BOARD_NAME_FIELD)
    private MobileElement boardNameField;

    @AndroidFindBy(id = TEAM_DROPDOWN)
    private MobileElement teamDropdown;

    @AndroidFindBy(xpath = LIST_OF_TEAMS_XPATH)
    private List<MobileElement> listOfteams;

    @AndroidFindBy(id = CREATE_BUTTON)
    private MobileElement createButton;

    @AndroidFindBy(xpath = OPEN_SIDE_DRAWER_XPATH)
    private MobileElement openSideDrawerButton;

    @AndroidFindBy(xpath = HEADER_NAME_XPATH)
    private MobileElement headerName;

    @FindBy(xpath = SIDE_DRAWER_BOARDS_XPATH)
    private MobileElement boardsButtonSideMenu;

    @AndroidFindBy(xpath = AVAILABLE_BOARDS_XPATH)
    private List<WebElement> listOfBoards;

    public Home(final WebDriver driver) {
        super(driver);
    }

    public void addButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.trello:id/view_pager")));
        addButton.click();
    }

    public void createBasicBoard() {
        addButtonClick();
        addBoardButton.click();
    }

    public void setBoardValues(final String boardName) {
        wait.until(ExpectedConditions.visibilityOf(teamDropdown));
        boardNameField.sendKeys(boardName);
        teamDropdown.click();
        listOfteams.get(0).click();
        createButton.click();
    }

    public void openSideDrawer() {
        wait.until(ExpectedConditions.visibilityOf(openSideDrawerButton));
        openSideDrawerButton.click();
    }

    public void openSideDrawerIf(final String headerNameToValidate) {
        if (!isHomeDisplayed(headerNameToValidate)) {
            openSideDrawer();
        }
    }

    public void goToBoards() {
        if ((!isHomeDisplayed(BOARD_EN))) {
            wait.until(ExpectedConditions.visibilityOf(openSideDrawerButton));
            openSideDrawerButton.click();
            boardsButtonSideMenu.click();
        }
    }

    public boolean isHomeDisplayed(final String headerNameToValidate) {
        wait.until(ExpectedConditions.visibilityOf(headerName));
        String validator = headerName.getText();
        return validator.equals(headerNameToValidate);
    }

    public void selectBoard(final String name) {
        wait.until(ExpectedConditions.visibilityOfAllElements((listOfBoards)));
        for (WebElement search : listOfBoards) {
            if (search.getText().equals(name)) {
                search.click();
                break;
            }
        }
    }
}
