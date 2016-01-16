package com.whatsapp.tests;

import com.whatsapp.config.Driver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by kdl on 21.12.15.
 */
public class TestsSuite {
    public static AndroidDriver driver;
    public static WebDriverWait wait;
    public static TouchActions touchScreen;
//    public static Helper helper;

    TestsSuite() {
        driver = Driver.initDriver();
        wait = new WebDriverWait(driver, 4);
        touchScreen = new TouchActions(driver);
//        helper = new Helper();
    }

//    @Test
//    public void test() throws InterruptedException {
//        Messaging messaging = new Messaging();
//        messaging.initDriver(driver,wait,touchScreen,helper);
//        messaging.deleteMsgs();
//    }

//    @Test
//    public void swipe() throws InterruptedException {
//        Messaging messaging = new Messaging();
//        messaging.initDriver(driver,wait,touchScreen,helper);
//        messaging.whatsAppSwipe();
//    }

//    @Test
//    public void visibleTest() throws InterruptedException {
//        Visibility visible = new Visibility();
//        visible.initDriver(driver,wait,touchScreen,helper);
//        visible.invisibleTest();
//    }
    @Test(groups = {"messages"})
    public void contactChat() {
        Messaging chating = new Messaging(driver,wait,touchScreen);
        chating.openContactChat(0);
//        chating.sendRandomTextMessage();
//        chating.sendTextMessage();
//        chating.sendEmojiMsg();
//        chating.checkMenuItems(5);
//        chating.clickChatMenuItem(3);
        chating.sendImageMsg();
    }


    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}