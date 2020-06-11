package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.ListPage;
import org.fundacionjala.core.ui.form.FormPage;

import java.util.Map;

import static org.fundacionjala.core.ui.driver.DriverFactory.getDriver;
import static org.testng.Assert.assertTrue;

public final class CardStepDef {

    private final ListPage listPage;
    private FormPage<?> formPage;

    public CardStepDef() {
        this.listPage = new ListPage(getDriver());
    }


    @When("I create a card on {string} list with:")
    public void createCardOnList(final String listName, final Map<String, String> data) {
        formPage = listPage.selectList(listName).createCard();
        formPage.fillForm(data);
        formPage.submit();
    }

    @Then("I should have a card on {string} list with:")
    public void validateCardCreation(final String listName, final Map<String, String> data) {
        assertTrue(listPage.selectList(listName).containsCard(data));
    }

    @When("I move {string} card from {string} to {string}")
    public void iMoveCardFromTo(final String cardName, final String sourceList, final String targeList) {
        listPage.selectList(sourceList)
                .selectCard(cardName)
                .dragAndDropTo(targeList);

    }
}
