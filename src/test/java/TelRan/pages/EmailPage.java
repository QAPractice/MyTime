package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Л on 5/2/2015.
 */
public class EmailPage extends Page {
    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='availableEmails']")
    WebElement availableEmailsField;
    @FindBy(xpath = "//*[@id='sendEmails']")
    WebElement emailsToSendField;
    @FindBy(xpath = "//*[@id='typedAddress']")
    WebElement typedAddressField;
    @FindBy(xpath = "//input[@value='Add']")
    WebElement addButton;
    @FindBy(xpath = "//input[@value='Add All']")
    WebElement addAllButton;
    @FindBy(xpath = "//input[@value='Remove']")
    WebElement removeButton;
    @FindBy(xpath = "//input[@value='Remove All']")
    WebElement removeAllButton;
    @FindBy(xpath = "//input[@value='Send']")
    WebElement sendButton;

    public void typeEmail(String email){
        setElementText(typedAddressField, email);
    }
    public void clickAdd (){
        clickElement(addButton);
    }
    public void clickSend (){
        clickElement(sendButton);
    }

}
