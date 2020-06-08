package org.fundacionjala.Pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public final class Home extends PageObject {

    private final static String ADD_BUTTON = "com.trello:id/add_fab";
    private final static String ADD_BOARD_BUTTON = "com.trello:id/add_board_fab";
    private final static String BOARD_NAME_FIELD = "com.trello:id/board_name";
    private final static String TEAM_DROPDOWN = "com.trello:id/team_spinner";
    private final static String LIST_OF_TEAMS_XPATH = "//android.widget.ListView/android.view.ViewGroup";
    private final static String CREATE_BUTTON = "com.trello:id/create_board";
    private final static String BOARD_TITLE = "com.trello:id/toolbar_title";

    @FindBy(id = ADD_BUTTON)
    private MobileElement addButton;

    @FindBy(id = ADD_BOARD_BUTTON)
    private MobileElement addCardButton;

    @FindBy(id = BOARD_NAME_FIELD)
    private MobileElement boardNameField;

    @FindBy(id = TEAM_DROPDOWN)
    private MobileElement teamDropdown;

    @FindBy(xpath = LIST_OF_TEAMS_XPATH)
    private List<MobileElement> listOfteams;

    @FindBy(id = CREATE_BUTTON)
    private MobileElement createButton;

    @FindBy(id = BOARD_TITLE)
    private MobileElement boardTitle;

    public Home(final WebDriver driver) {
        super(driver);
    }

    public void addButtonClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.trello:id/view_pager")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout")));
        addButton.click();
    }

    public String getBoardTitle() {
        return boardTitle.getText();
    }

    public void createBasicBoard(final String boardName) {
        addButtonClick();
        addCardButton.click();
        wait.until(ExpectedConditions.visibilityOf(boardNameField));
        boardNameField.sendKeys(boardName);
        teamDropdown.click();
        listOfteams.get(0).click();
        createButton.click();
    }
}
