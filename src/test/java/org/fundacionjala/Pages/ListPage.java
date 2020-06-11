package org.fundacionjala.Pages;

import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public final class ListPage extends PageObject {
    private static final String CARD_LIST_CONTAINER =
            "//*[@text='%s']/ancestor::android.widget.LinearLayout[@resource-id='com.trello:id/card_list_container']";
    private static final String FOOTER_ADD_CARD = "//*[@resource-id='com.trello:id/cardlist_footer_container']";
    private static final String NAME = "name";
    private static final String CARD_TEXT_PATH = "//*[@resource-id='com.trello:id/cardText'][@text='%s']";
    private String listPath;

    public ListPage(final WebDriver driver) {
        super(driver);
    }

    public ListPage selectList(final String name) {
        String locator = String.format(CARD_LIST_CONTAINER, name);
        listPath = locator;
        By element = By.xpath(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public CardForm createCard() {
        String locator = listPath.concat(FOOTER_ADD_CARD);
        By element = By.xpath(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement button = driver.findElement(element);
        button.click();
        return new CardForm(driver);
    }

    public boolean containsCard(final Map<String, String> data) {
        String name = data.get(NAME);
        String cardLocator = listPath.concat(String.format(CARD_TEXT_PATH, name));
        List<WebElement> cards = driver.findElements(By.xpath(cardLocator));
        for (WebElement card : cards) {
            if (card.getText().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
