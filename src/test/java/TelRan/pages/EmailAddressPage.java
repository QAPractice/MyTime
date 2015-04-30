package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marina on 4/18/2015.
 */
public class EmailAddressPage extends Page {
    //buttons


    public EmailAddressPage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

}
