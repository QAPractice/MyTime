package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * i* Created by zizi on 30.04.2015.
 */


public class CollaborationPage1 extends Page {


    //field
    @FindBy(id = "polelogin")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    //button
    @FindBy(id = "1")
    WebElement loginButton;
    //field
    @FindBy(xpath = "l//div[2]/div[1]/form[1]/div/button")
    WebElement createNewCalendarField;

    //button
    @FindBy(xpath = "//div[2]/div[1]/form[2]/div//tr[3]/td[7]/a")
    WebElement collaborationButton;

    //button

    @FindBy(xpath = "//div[2]/div[1]/form[2]/div//tr[5]/td[6]/input")
    WebElement sendInvitationButton;

    //button
    @FindBy(xpath = "//div[2]/div[1]/form[2]/div//tr[5]/td[7]/input")
    WebElement setAppointmentButton;


    public CollaborationPage1(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

    public void clickCollaborationButton() {
        clickElement(collaborationButton);
    }

    public void clickSendInvitationButton() {
        clickElement(sendInvitationButton);
    }

    public void clickSetAppointmentButton() {
        clickElement(setAppointmentButton);
    }
}
