package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Роман on 18.04.2015.
 */
public class CollaborationPage extends Page {

    //fields
    @FindBy(id = "polelogin" )
    WebElement usernameField;

    @FindBy(id = "password" )
    WebElement passwordField;

    //buttons
    @FindBy(id = "1" )
    WebElement loginButton;

    // button
    @FindBy(xpath = "//*[@id='placetable']/table/tbody/tr[3]/td[7]/a/img" )
    WebElement collaborationButton;

    // button
    @FindBy(xpath = "//*[@id='collab861']/td[6]/input" )
    WebElement sendInvitationButton;

    // button
    @FindBy(xpath = "//*[@id='collab861']/td[7]/input" )
    WebElement setAppointmentButton;


    public CollaborationPage(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }

}
