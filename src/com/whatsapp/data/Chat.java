package com.whatsapp.data;

import com.whatsapp.config.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

/**
 * Created by kdl on 30.12.15.
 */
public class Chat {
    public static String randomData = Helper.generateText(new Random(), Chat.msgTestData, 10);
    public final static String optionsRU = "Другие параметры";
    public final static String optionsEN = "More options";

    public final static String attachM = "Attach";

    public final static String msgTestData = "Appium test!";
    public final static String msgTestData2 = "Zeus is a Greek god of the lighting";


    @FindBy(id = "toolbar")
    public static WebElement activityBar;

    @FindBy(className = "android.widget.RelativeLayout")
    public static List<WebElement> chatItem;

    @FindBy(id = "conversations_row_contact_name")
    public static List<WebElement> chatContacts;

    @FindBy(id = "list")
    public static WebElement chatList;

    @FindBy(id = "entry")
    public static WebElement messageField;

    @FindBy(id = "emoji_picker_btn")
    public static WebElement emojiBtn;

    @FindBy(id = "send")
    public static WebElement sendButton;

    @FindBy(id = "status")
    public static WebElement msgStatus;

    @FindBy(id = "message_text")
    public static List<WebElement> msgItems;

    @FindBy(id = "menuitem_new_conversation")
    public static WebElement newActiveBarChat;

    @FindBy(className = "android.widget.LinearLayout")
    public static List<WebElement> menuList;

    @FindBy(name = optionsRU)
    public static WebElement menuOptionsRU;

    @FindBy(name = optionsEN)
    public static WebElement menuOptionsEN;

    @FindBy(name = attachM)
    public static WebElement menuAttach;

    @FindBy(id = "pickfiletype_gallery")
    public static WebElement attachImage;

    @FindBy(id = "thumbnail")
    public static List<WebElement> albums;

    @FindBy(className = "android.widget.ImageView")
    public static List<WebElement> albumItem;

    @FindBy(id = "ok_btn")
    public static WebElement sendAlbumImg;

    @FindBy(id = "pickfiletype_camera")
    public static WebElement attachPhoto;

    @FindBy(id = "pickfiletype_video")
    public static WebElement attachVideo;

    @FindBy(id = "pickfiletype_audio")
    public static WebElement attachAudio;

    @FindBy(id = "pickfiletype_location")
    public static WebElement attachLocation;

    @FindBy(id = "pickfiletype_contact")
    public static WebElement attachContact;


    @FindBy(id = "group_name")
    public static WebElement groupInput;

    @FindBy(id = "action_done")
    public static WebElement submitAction;

    @FindBy(id = "autocomplete_contact_name")
    public static WebElement contactNameInput;

    @FindBy(id = "autocomplete_contact_anchor")
    public static WebElement chooseContact;

    @FindBy(name = msgTestData)
    public static WebElement findGroup;

    @FindBy(id = "menuitem_delete")
    public static WebElement abDelete;

    @FindBy(id = "button1")
    public static WebElement popupDeleteBtn;

    @FindBy(id = "button2")
    public static WebElement popupCancelBtn;

}
