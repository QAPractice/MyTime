package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anton on 18-Apr-15.
 */

public class MainPage extends Page {

    //buttons

    @FindBy (xpath = "//*[@id='form2']/div/button")
    WebElement createcalendarLink;

    @FindBy(id = "'852'/td[2]" )
    WebElement ShareButton;
    @FindBy(id = "'852'/td[3]" )
    WebElement ShareOnGoogleButton;
    @FindBy(id = "'852'/td[4]" )
    WebElement ShareOnFacebookButton;
//save

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
