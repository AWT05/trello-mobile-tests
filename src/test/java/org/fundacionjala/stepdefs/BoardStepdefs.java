package org.fundacionjala.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.Pages.Home;
import org.fundacionjala.core.ui.driver.SharedDriver;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.fundacionjala.core.ui.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertTrue;

public class BoardStepdefs {
    private Home homepage;
    protected static WebDriver driver;

    public BoardStepdefs(final SharedDriver driver) {
        homepage = new Home(getDriver());
    }


    /**
     * Creates an object from header.
     *
     * @param entity Element to be created.
     * @param data   Elements values.
     */
    @When("I create a {string} from addButton with the following data")
    public void createEntityWithData(final String entity, final Map<String, String> data) {
        form = header.createElement(entity);
        form.fillForm(data);
        form.submit();
    }















    /**
     * Creates a card with specific data.
     *
     * @param listName expected name of the list where card will be created.
     * @param data     expected card data.
     */
    @When("I create a card on {string} list with:")
    public void iCreateCardWith(final String listName, final Map<String, String> data) {
        menuBoard.closeMenuOptions();
        form = listPage.createNewCard(listName);
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the card creation.
     *
     * @param listName     expected list name where to find the card.
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a card on {string} list with:")
    public void iShouldHaveACardWith(final String listName, final Map<String, String> expectedData) {
        List<String> cardNamesList = cardPage.getAllCardNames(listName);
        assertTrue(cardNamesList.contains(expectedData.get("name")));
    }

}



