package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.Board;
import org.fundacionjala.trello.pages.Home;
import org.fundacionjala.core.ui.driver.SharedDriver;
import org.fundacionjala.core.ui.form.FormPage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.fundacionjala.core.ui.driver.DriverFactory.getDriver;
import static org.testng.AssertJUnit.assertEquals;

public final class BoardStepdefs {

    private FormPage<?> form;
    private Home homepage;
    private Board boardPage;
    protected static WebDriver driver;

    public BoardStepdefs(final SharedDriver driver) {
        homepage = new Home(getDriver());
        boardPage = new Board(getDriver());
    }

    /**
     * Creates an board from addButton.
     *
     * @param data Elements values.
     */
    @When("I create a board from addButton with the following data")
    public void createEntityWithData(final Map<String, String> data) {
        homepage.createBasicBoard();
        homepage.setBoardValues(data.get("title"));
    }

    @Then("{string} board page should be visible")
    public void boardPageShouldBeVisible(final String boardNameTitle) {
        assertEquals(boardNameTitle, boardPage.getBoardTitle());
    }

    @When("I navigate to boards home page")
    public void iNavigateToBoardsHomePage() {
        boardPage.closeBoard();
        homepage.goToBoards();
    }

    @When("I select {string} board")
    public void selectBoardFromSection(final String name) {
        homepage.selectBoard(name);
    }

}
