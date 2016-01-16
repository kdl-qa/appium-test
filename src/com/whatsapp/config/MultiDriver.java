package com.whatsapp.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

/**
 * Created by kdl on 30.12.15.
 */
public class MultiDriver {
    public static final String FIRST_NODE_URL = "http://10.0.1.69:4745/wd/hub";
    public static final String SECOND_NODE_URL = "http://10.0.1.69:4746/wd/hub";

    public static AndroidDriver driver = null;

    public static AndroidDriver init(int driverID) {
        if (driverID == 1) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("deviceName", "Mi");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appPackage", "com.whatsapp");
                capabilities.setCapability("appActivity", "com.whatsapp.Main");
                capabilities.setCapability("unicodeKeyboard", true);
                driver = new SwipeableDriver(new URL(FIRST_NODE_URL), capabilities);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return driver;
        } else if (driverID == 2) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("deviceName", "Meizu");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("appPackage", "com.whatsapp");
                capabilities.setCapability("appActivity", "com.whatsapp.Main");
                capabilities.setCapability("unicodeKeyboard", true);
                driver = new SwipeableDriver(new URL(SECOND_NODE_URL), capabilities);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return driver;
        }
        return null;
    }

}
