package scenarios;

import org.testng.annotations.Test;

import java.io.IOException;

import static NativeMobileTestData.AppiumWebTestElements.BROWSER_TITLE;
import static config.DriverSetup.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlMatches;
import static org.testng.Assert.assertEquals;

/**
 * Opens website and check that website is successfully opened.
 *
 * @throws IOException
 */
@Test(groups = "web")
public class WebMobileTests {

    @Test(description = "Open website and assert it is opened")
    public void webTest() throws IOException {

        // 1 Open Website and check page is opened
        driver().get(webUrl);
        driverWait().until(urlMatches(webUrl + "/"));

        // 2 Check correct browser title
        assertEquals(driver().getTitle(), BROWSER_TITLE.value);

        System.out.println("Site opening don");
    }
}
