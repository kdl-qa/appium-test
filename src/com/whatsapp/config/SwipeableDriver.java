package com.whatsapp.config;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.RemoteTouchScreen;

import java.net.URL;

/**
 * Created by kdl on 21.12.15.
 */
public class SwipeableDriver extends AndroidDriver implements HasTouchScreen {
    private RemoteTouchScreen touch;

    public SwipeableDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
        touch = new RemoteTouchScreen(getExecuteMethod());
    }

    @Override
    public TouchScreen getTouch() {
        return touch;
    }
}
