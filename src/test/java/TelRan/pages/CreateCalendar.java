package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alex on 4/17/2015.
 */

public class CreateCalendar  extends Page {

    //fields
    @FindBy(id = "polelogin" )
    WebElement usernameField;

    @FindBy(id = "password" )
    WebElement passwordField;

    //buttons
    @FindBy(id = "1" )
    WebElement loginButton;

    public CreateCalendar(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }

}
