package separateClasses;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static config.DriverSetup.*;
import static config.TestPropertiesReader.setConfigFile;


/**
 * Loads and reads properties to prepare driver for tests. Closes driver after test.
 *
 * @throws IOException
 */

@Test(groups = {"native", "web"})
public class Hooks {

    @Parameters("configFile")
    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp(String configFile) throws IOException {
        setConfigFile(configFile);
        setProperties();
        prepareDriver();
        System.out.println("Driver prepared");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws MalformedURLException {
        driver().quit();
        System.out.println("Driver closed");
    }
}
