package org.fundacionjala.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.Pages.Board;
import org.fundacionjala.Pages.list.ListPage;
import org.fundacionjala.core.ui.driver.SharedDriver;
import org.fundacionjala.core.ui.form.FormPage;

import java.util.Map;

import static org.fundacionjala.core.ui.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class ListStepdefs {

    private FormPage<?> form;
    private Board boardPage;
    private ListPage listPage;

    public ListStepdefs(final SharedDriver driver) {
        boardPage = new Board(getDriver());
        listPage = new ListPage(getDriver());
    }

    /**
     * Creates a list with specific data.
     *
     * @param data expected list data.
     */
    @When("I create a List with:")
    public void iCreateAListWith(final Map<String, String> data) {
        form = boardPage.createNewList();
        form.fillForm(data);
        form.submit();
    }

    /**
     * Validates the list creation.
     *
     * @param expectedData expected data to validate the creation.
     */
    @Then("I should have a list (created)(updated) with:")
    public void iShouldHaveAListCreatedWith(final Map<String, String> expectedData) {
        String currentData = listPage.getListName();
        assertEquals(currentData, expectedData.get("name"));
    }


    /**
     * Updates a list with specific data.
     *
     * @param listName to set the list name.
     * @param data     expected list data.
     */
    @When("I update the {string} List with:")
    public void iUpdateTheListWith(final String listName, final Map<String, String> data) {
        form = boardPage.UpdateList(listName);
        form.fillForm(data);
        form.submit();
    }
}
