package org.fundacionjala.stepdefs;

import io.cucumber.java.en.Given;
import org.fundacionjala.Pages.login.LoginPage;
import org.fundacionjala.context.UserTrello;
import org.fundacionjala.core.ui.driver.SharedDriver;

import static org.fundacionjala.core.ui.driver.DriverFactory.getDriver;

public class LoginStepDefs {

    LoginPage login;

    public LoginStepDefs(final SharedDriver driver){
        login = new LoginPage(getDriver());
    }

    /**
     * Logins in trello page.
     *
     * @param userAccount keyword to get an user.
     */
    @Given("I log in with my Trello account as {string}")
    public void iLogInWithMyTrelloAccountAs(String userAccount) {
        if(login.skippLogin()) {
            UserTrello user = new UserTrello(userAccount);
            login.acceptMessage().pressLoginButton()
                    .setUserName(user.getEmail())
                    .setPassword(user.getPassword());
        }
    }
}
