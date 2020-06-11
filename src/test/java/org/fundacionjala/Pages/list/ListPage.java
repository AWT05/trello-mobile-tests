package org.fundacionjala.Pages.list;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.fundacionjala.core.ui.page.PageObject;
import org.openqa.selenium.WebDriver;

public final class ListPage extends PageObject {

    private static final String LIST_NAME = "//android.widget.EditText";

    @AndroidFindBy(xpath = LIST_NAME)
    private MobileElement listName;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public String getListName(){
        return listName.getText();
    }
}
