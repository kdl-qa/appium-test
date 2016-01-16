package com.whatsapp.suits;

import com.whatsapp.config.MultiDriver;
import com.whatsapp.tests.Messaging;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by kdl on 30.12.15.
 */
public class ParallelMessageSuite {
    AndroidDriver miDriver;
    AndroidDriver meizuDriver;
    WebDriverWait wait1;
    WebDriverWait wait2;
    TouchActions touchScreen1;
    TouchActions touchScreen2;

    ParallelMessageSuite() {
        miDriver = MultiDriver.init(1);
        meizuDriver = MultiDriver.init(2);
        wait1 = new WebDriverWait(miDriver, 4);
        wait2 = new WebDriverWait(meizuDriver, 4);
        touchScreen1 = new TouchActions(miDriver);
        touchScreen2 = new TouchActions(meizuDriver);
    }

    @Test(groups = {"sendTextMessage"}, priority = 1)
    public void sendMessage() {
        Messaging send = new Messaging(miDriver, wait1, touchScreen1);
        send.openContactChat(0);
        send.sendRandomTextMessage();
    }

    // TODO: place the variable where you would save the random data for check
    @Test(groups = {"getMessage"}, priority = 2)
    public void deleteMessage() {
        Messaging receive = new Messaging(meizuDriver, wait2, touchScreen2);
        receive.openContactChat(0);
//        receive.deleteMsgs();
        receive.deleteRandomMsgs();
    }

    @AfterClass
    public void closeDrivers() {
        miDriver.quit();
        meizuDriver.quit();
    }
}
