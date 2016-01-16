package com.whatsapp.tests;

import com.whatsapp.config.Helper;
import com.whatsapp.data.Chat;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;



/**
 * Created by kdl on 21.12.15.
 */
public class Messaging {
    //    @Test(groups = { "init" })
    public Messaging(AndroidDriver driver, WebDriverWait wait, TouchActions touchScreen) {
        this.wait = wait;
        this.touchScreen = touchScreen;
        this.driver = driver;
//        this.helper = helper;

        PageFactory.initElements(driver, Chat.class); //path to locator class
    }

    private WebDriverWait wait;
    private TouchActions touchScreen;
    private WebDriver driver;


    public void deleteRandomMsgs() {
        for (WebElement msg : Chat.msgItems) {
            if (msg.getText().equalsIgnoreCase(Chat.randomData)) {
                System.out.println("Find message to delete");
                touchScreen.longPress(msg).perform();
                Chat.abDelete.click();
                Chat.popupDeleteBtn.click();
            }
        }
    }


    public void deleteMsgs() {
//    wait.until(presenceOfElementLocated(By.id("list")));
        for (WebElement msg : Chat.msgItems) {
            if (msg.getText().equalsIgnoreCase(Chat.msgTestData)) {
                System.out.println("Message find to delete");
                touchScreen.longPress(msg).perform();
                Chat.abDelete.click();
                Chat.popupDeleteBtn.click();
            } else {
                System.out.println("Message do not find");
            }
        }


//
//    int listMsgs = Chat.msgItems.size();
//    System.out.println(listMsgs);
//    WebElement lastListMsg = Chat.msgItems.get(listMsgs);
//    System.out.println(lastListMsg.getText());
//    assertEquals(Chat.msgTestData, lastListMsg.getText());
//    touchScreen.longPress(lastListMsg);
//    int lastListMsg = msgList;

//    Thread.sleep(3000);
    }

    //@Test(dependsOnGroups = { "init.*" })
    public void whatsAppSwipe() throws InterruptedException {
        wait.until(presenceOfElementLocated(By.id("list")));
        touchScreen.flick(Chat.chatList, -300, 0, 95).perform();
        Thread.sleep(3000);
        touchScreen.flick(Chat.chatList, 300, 0, 95).perform();

//    touchScreen.longPress(chatList).move(200,500).release().perform();
    }

    public void openContactChat(int n) {
        wait.until(presenceOfElementLocated(By.id("toolbar")));
        if (Chat.chatItem.isEmpty()) {
            System.out.println("You don't have any chats");
        } else {
            wait.until(presenceOfElementLocated(By.id("list")));
            Chat.chatItem.get(n).click();
        }
    }

    //@Test(dependsOnGroups = { "init.*" })
    public void checkMenuItems(int n) {
        wait.until(presenceOfElementLocated(By.id("toolbar")));

        for (int i=0; i <= n; i++) {
//            Chat.menuOptionsRU.click();
            Chat.menuOptionsEN.click();
            Chat.menuList.get(i).click();
            driver.navigate().back();
        }
    }

    public void clickChatMenuItem(int n) {
//        Chat.menuOptionsRU.click();
        Chat.menuOptionsEN.click();
        Chat.menuList.get(n).click();
    }

    //@Test(dependsOnGroups = { "init.*" })
    public void createChatGroup() {
        wait.until(presenceOfElementLocated(By.id("list")));
        Chat.menuOptionsRU.click();
        Chat.menuList.get(0).click();
        Chat.groupInput.sendKeys(Chat.msgTestData);
        Chat.submitAction.click();
        Chat.contactNameInput.sendKeys("дмитрий кравченко");
        Chat.chooseContact.click();
        Chat.submitAction.click();
    }

    public void openGroupChat() {
        wait.until(presenceOfElementLocated(By.id("toolbar")));

        if (Chat.chatContacts.isEmpty()) {
            System.out.println("You don't have any chats");
        } else {
            wait.until(presenceOfElementLocated(By.id("list")));

            int lastChat = Chat.chatContacts.size() - 1;
            System.out.println(lastChat);
            WebElement lastChatItem = Chat.chatContacts.get(lastChat);
            System.out.println(lastChatItem);
            Helper.checkElementPresence(Chat.chatContacts, Chat.msgTestData);
        }

    }

    public void sendTextMessage() {
        wait.until(presenceOfElementLocated(By.id("entry")));
        Chat.messageField.sendKeys(Chat.msgTestData);
        Chat.sendButton.click();
        for (WebElement msg : Chat.msgItems) {
            if (msg.getText().equalsIgnoreCase(Chat.msgTestData)) {
                System.out.println("Message Sent!");
            } else {
                System.out.println("Message not presented!");
            }
        }
    }

    public void sendRandomTextMessage() {
        wait.until(presenceOfElementLocated(By.id("entry")));
        Chat.messageField.sendKeys(Chat.randomData);
        Chat.sendButton.click();
    }

    public void sendEmojiMsg() {
        Chat.messageField.sendKeys("\ud83d\uddfd");
        Chat.sendButton.click();
    }

    public void sendImageMsg() {
        Chat.menuAttach.click();
        Chat.attachImage.click();
        Chat.albums.get(0).click();
        Chat.albumItem.get(0).click();
        Chat.sendAlbumImg.click();


    }
//
//public void checkLastMsg(){
//
//}

}
