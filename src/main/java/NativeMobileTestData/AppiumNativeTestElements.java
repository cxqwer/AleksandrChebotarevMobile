package NativeMobileTestData;

/**
 * store of locators of NativeMobileTest (remove the hardcore )
 */

public enum AppiumNativeTestElements {
    ADD_CONTACT_BUTTON("com.example.android.contactmanager:id/addContactButton"),
    ACCOUNT_SPINNER("com.example.android.contactmanager:id/accountSpinner"),
    CONTACT_NAME_EDIT_TEXT("com.example.android.contactmanager:id/contactNameEditText"),
    CONTACT_PHONE_EDIT_TEXT("com.example.android.contactmanager:id/contactPhoneEditText"),
    CONTACT_EMAIL_EDIT_TEXT("com.example.android.contactmanager:id/contactEmailEditText");
    public String id;

    AppiumNativeTestElements(String id) {
        this.id = id;
    }
}
