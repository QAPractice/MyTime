package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marina on 4/18/2015.
 */
public class SyncCooglePage extends Page {
    //buttons
    @FindBy(xpath = "//*[@id='log']/span[3]/button")
    WebElement accountSettings;

    @FindBy(xpath = "//*[@id='___signin_0']/button")
    WebElement enterAccount;

    @FindBy(xpath = "//*[@id='savebutton']")
    WebElement saveSettings;

    @FindBy(xpath = "//*[@id='form2']/div/button")
    WebElement createCalendar;

    //checkBox
    @FindBy(xpath = "//*[@id='second']/div/p[8]")
    WebElement googleAccountOption;


    public SyncCooglePage(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }

}
