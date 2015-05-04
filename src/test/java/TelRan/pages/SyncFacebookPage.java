package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anton on 01-May-15.
 */
public class SyncFacebookPage extends Page {

    public SyncFacebookPage(WebDriver driver ){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
