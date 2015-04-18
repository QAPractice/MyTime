package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by oshil on 18.04.2015.
 */
public class AuthorisationSocialNetworksPage extends Page {

    //fields
    @FindBy(id = "polelogin" )
    WebElement usernameField;

    @FindBy(id = "password" )
    WebElement passwordField;

    //buttons
    @FindBy(id = "1" )
    WebElement loginButton;

    @FindBy(xpath = ("//*[@id='___signin_0']/button") )
    WebElement VoitiButton;


    //links
    @FindBy(xpath = ("//*[@id='log']/span[3]/button"))
    WebElement accountSettings;

    public AuthorisationSocialNetworksPage(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }
}
