package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestPropertiesReader {
    private static String driverCapabilities;
    private static Properties driverProperties = new Properties();
    
    public static String getProperty(String key) {
        InputStream in = TestPropertiesReader.class.getResourceAsStream(driverCapabilities);
        try {
            driverProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!driverProperties.containsKey(key)){
            return driverProperties.getProperty(key, null);
        }
        return driverProperties.getProperty(key);
    }

    public static void setConfigFile(String configFileName){
        driverCapabilities = configFileName;
    }
}
