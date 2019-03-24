package additionalParameters;

import org.openqa.selenium.remote.CapabilityType;

public interface AdditionalCapabilityType extends CapabilityType {
    String PATH_APK="pathApk";
    String APK_NAME="apkName";
    String DRIVER_URL="driverUrl";
    String WEB_URL="webUrl";
    String ANDROID="Android";
    String iOS="ios";
}
