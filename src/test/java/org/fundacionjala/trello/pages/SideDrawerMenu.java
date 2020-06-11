package org.fundacionjala.trello.pages;

import io.appium.java_client.MobileElement;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class SideDrawerMenu extends PageObject {

    private static final String BOARDS_XPATH = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
            + "android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout"
            + ".widget.DrawerLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view."
            + "ViewGroup[2]/android.widget.TextView";

    @FindBy(xpath = BOARDS_XPATH)
    private MobileElement boardsButton;

    public SideDrawerMenu(final WebDriver driver) {
        super(driver);
    }

    public void openBoards(final Home homePage) {
        homePage.openSideDrawerIf("Boards");
        wait.until(ExpectedConditions.elementToBeClickable(boardsButton));
        boardsButton.click();
    }
}
