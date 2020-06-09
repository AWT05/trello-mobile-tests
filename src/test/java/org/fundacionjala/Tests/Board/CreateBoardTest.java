package org.fundacionjala.Tests.Board;

import org.fundacionjala.Pages.Home;
import org.fundacionjala.Pages.Login;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreateBoardTest extends FunctionalTest {

    @Test
    public void createBoardMobileTest() {
//        Login loginTest = new Login(driver);
//        loginTest.loginWithSmartLock();
        Home homeTest = new Home(driver);
        homeTest.createBasicBoard();
        homeTest.setBoardValues("Wild Hunt");
        assertEquals("Wild Hunt", homeTest.getBoardTitle());
    }
}
