package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static NativeMobileTestData.AppiumNativeTestElements.*;
import static config.DriverSetup.driver;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * This simple test just click on button 'Add contact' and check elements
 */

@Test(groups = "native")
public class NativeMobileTest {

    @Test
    public void SimplestTest() throws IOException {

        //1 Click button 'Add Contact'
        WebElement abbButton = driver().findElement(By.id(ADD_CONTACT_BUTTON.id));
        abbButton.click();

        //2 Check 'Target Account' is exists
        WebElement targetAccount = driver().findElement(By.id(ACCOUNT_SPINNER.id));
        assertTrue(targetAccount.isDisplayed());

        //3 Check 'Contact Phone' field is exists
        WebElement phone = driver().findElement(By.id(CONTACT_PHONE_EDIT_TEXT.id));
        assertTrue(phone.isDisplayed());

        //4 Check 'Contact Name' field is exists
        WebElement name = driver().findElement(By.id(CONTACT_NAME_EDIT_TEXT.id));
        assertTrue(name.isDisplayed());

        //5 Check 'Contact E-mail' field is exists
        WebElement email = driver().findElement(By.id(CONTACT_EMAIL_EDIT_TEXT.id));
        assertTrue(email.isDisplayed());

        // 6 Check keyboard is visible
        assertNotNull(driver().getKeyboard());

        System.out.println("Native mobile test complete");
    }
}
