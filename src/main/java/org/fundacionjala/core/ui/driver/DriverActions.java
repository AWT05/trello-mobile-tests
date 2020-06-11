package org.fundacionjala.core.ui.driver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.fundacionjala.core.Environment;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverActions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public DriverActions(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Indicates if the actual element is displayed.
     *
     * @return true if actual element is displayed, else false.
     */
    public Boolean isElementDisplayed(WebElement webElement) {
        Environment env = Environment.getInstance();
        try {
            wait.withTimeout(env.getReducedTime(), TimeUnit.SECONDS);
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException e) {
            return false;
        } finally {
            wait.withTimeout(env.getExplicitTimeWait(), TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     * Swipes the screen right.
     *
     * @param webElement web element.
     */
    public void SwipeScreenRight(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        Dimension dimension = webElement.getSize();
        int anchor = webElement.getSize().getHeight() / 2;
        int scrollStart = (int) (dimension.getWidth() * 0.8);
        int scrollEnd = (int) (dimension.getWidth() * 0.2);
        performSwipeActions(scrollStart, scrollEnd, anchor);
    }

    /**
     * Performs the swipe actions.
     *
     * @param start  initial point to begin the swipe.
     * @param end    final point to finish the swipe.
     * @param anchor set the direction.
     */
    private void performSwipeActions(int start, int end, int anchor) {
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(start, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end, anchor))
                .release().perform();
    }
}
