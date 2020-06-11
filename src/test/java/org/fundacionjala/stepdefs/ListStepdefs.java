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

    public ListStepdefs(SharedDriver driver) {
        boardPage = new Board(getDriver());
        listPage = new ListPage(getDriver());
    }

    @When("I create a List with:")
    public void iCreateAListWith(Map<String, String> data) {
        form = boardPage.createNewList();
        form.fillForm(data);
        form.submit();
    }

    @Then("I should have a list created with:")
    public void iShouldHaveAListCreatedWith(Map<String, String> expectedData) {
        String currentData = listPage.getListName();
        assertEquals(currentData,expectedData.get("name"));
    }
}
