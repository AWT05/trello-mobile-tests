package org.fundacionjala.Pages.list;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.fundacionjala.core.ui.form.FormFieldsEnum;
import org.fundacionjala.core.ui.form.FormPage;
import org.fundacionjala.core.ui.form.IFillerField;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.core.ui.form.FormFieldsEnum.NAME;

public final class CreateListForm extends FormPage<ListPage> {

    private static final String LIST_NAME_TEXT_FIELD = "com.trello:id/list_name_edit_text";
    private static final String CONFIRM_ICON = "com.trello:id/confirm";

    @AndroidFindBy(id = LIST_NAME_TEXT_FIELD)
    private MobileElement listNameTextField;

    @AndroidFindBy(id = CONFIRM_ICON)
    private MobileElement confirmIcon;

    public CreateListForm(final WebDriver driver) {
        super(driver);
    }

    /**
     * Provides all the fields that the form have.
     *
     * @return fields to be filled.
     */
    @Override
    protected Map<FormFieldsEnum, IFillerField> getFields() {
        Map<FormFieldsEnum, IFillerField> data = new HashMap<>();
        data.put(NAME, this::setListName);
        return data;
    }

    private void setListName(final String listName) {
        listNameTextField.clear();
        listNameTextField.sendKeys(listName);
    }

    /**
     * Submits all information in the form.
     *
     * @return next page object.
     */
    @Override
    public ListPage submit() {
        confirmIcon.click();
        return new ListPage(driver);
    }
}
