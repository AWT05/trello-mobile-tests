package org.fundacionjala.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.Pages.login.LoginPage;
import org.fundacionjala.core.entities.User;
import org.fundacionjala.core.ui.driver.SharedDriver;

import static org.fundacionjala.core.ui.driver.DriverFactory.getDriver;

public class LoginStepDefs {

    private LoginPage login;

    public LoginStepDefs(final SharedDriver driver) {
        login = new LoginPage(getDriver());
    }

    /**
     * Logins in trello page.
     *
     * @param userAccount keyword to get an user.
     */
    @Given("I log in with my Trello account as {string}")
    public void iLogInWithMyTrelloAccountAs(final String userAccount) {
        if (login.skipLogin()) {
            User user = new User(userAccount);
            login.acceptMessage().pressLoginButton()
                    .setUserName(user.getEmail())
                    .setPassword(user.getPassword());
        }
    }
}
