package scenarios;

import SeparateClasses.DriverSetupWeb;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSimpleTestGhrome extends DriverSetupWeb {

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        //prepareAndroidNative();
        prepareAndroidWeb();
    }

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}
