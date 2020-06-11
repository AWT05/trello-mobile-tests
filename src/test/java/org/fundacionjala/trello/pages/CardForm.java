package org.fundacionjala.trello.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.fundacionjala.core.ui.form.FormFieldsEnum;
import org.fundacionjala.core.ui.form.FormPage;
import org.fundacionjala.core.ui.form.IFillerField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static io.appium.java_client.android.nativekey.AndroidKey.ENTER;
import static org.fundacionjala.core.ui.form.FormFieldsEnum.NAME;

public final class CardForm extends FormPage<CardPage> {

    private static final String NAME_EDIT_TEXT = "com.trello:id/card_name_edit_text";

    @FindBy(id = NAME_EDIT_TEXT)
    private WebElement inputName;

    public CardForm(final WebDriver driver) {
        super(driver);
    }

    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(NAME, this::setName);
        return data;
    }

    @Override
    public CardPage submit() {
        ((AndroidDriver) driver).longPressKey(new KeyEvent(ENTER));
        return new CardPage(driver);
    }

    public CardForm setName(final String name) {
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.clear();
        inputName.sendKeys(name);
        return this;
    }
}
