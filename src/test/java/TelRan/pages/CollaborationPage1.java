package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * i* Created by zizi on 30.04.2015.
 */


public class CollaborationPage1 extends Page {


    @FindBy(xpath = "//div[2]/div[1]/form[2]/div//tr[3]/td[7]/a")
    WebElement collabrationButton;


    public CollaborationPage1(WebDriver driver) {

        super(driver);

        PageFactory.initElements(driver, this);
    }
}