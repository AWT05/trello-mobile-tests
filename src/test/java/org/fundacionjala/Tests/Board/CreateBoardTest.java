package org.fundacionjala.Tests.Board;

import org.fundacionjala.Pages.Board;
import org.fundacionjala.Pages.Home;
import org.fundacionjala.Pages.Login;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreateBoardTest extends FunctionalTest {

    @Test
    public void createBoardMobileTest() {
        //TO DO
//        Login loginTest = new Login(driver);
//        loginTest.loginWithSmartLock();
        Home homeTest = new Home(driver);
        Board boardTest = new Board(driver);
        homeTest.createBasicBoard();
        homeTest.setBoardValues("Wild Hunt");
        assertEquals("Wild Hunt", boardTest.getBoardTitle());
    }
}
