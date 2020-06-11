package org.fundacionjala.Pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public final class ListPage extends PageObject {
    private static final String LIST_PATH =
            "//*[@text='%s']/ancestor::*[@resource-id='com.trello:id/card_list_container']";
    private static final String CONTAINER_PATH = "/*[@resource-id='com.trello:id/recycler_view']";
    private static final String CARD_TEXT_PATH = "//*[@resource-id='com.trello:id/cardText'][@text='%s']";
    private static final String ADD_CARD_PATH = "//*[@resource-id='com.trello:id/cardlist_footer_container']";
    private static final String NAME = "name";
    private String listPath;
    private WebElement cardSelected;

    public ListPage(final WebDriver driver) {
        super(driver);
    }

    public ListPage selectList(final String name) {
        String locator = String.format(LIST_PATH, name);
        listPath = locator;
        By element = By.xpath(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public CardForm createCard() {
        String locator = listPath.concat(ADD_CARD_PATH);
        By buttonLocator = By.xpath(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        WebElement button = driver.findElement(buttonLocator);
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

    public ListPage selectCard(final String cardName) {
        String cardPath = listPath.concat(String.format(CARD_TEXT_PATH, cardName));
        By cardLocator = By.xpath(cardPath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardLocator));
        cardSelected = driver.findElement(cardLocator);
        return this;
    }

    public ListPage dragAndDropTo(final String targeName) {
        selectList(targeName);
        String containerPath = listPath.concat(CONTAINER_PATH);
        By targetLocator = By.xpath(containerPath);
        wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
        WebElement targetList = driver.findElement(targetLocator);
        TouchAction action = new TouchAction((MobileDriver) driver);
        action.longPress(ElementOption.element(cardSelected))
                .moveTo(PointOption.point(targetList.getLocation()))
                .release()
                .perform();
        return this;
    }
}
