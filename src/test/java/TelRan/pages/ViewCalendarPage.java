package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Marina on 5/2/2015.
 */
public class ViewCalendarPage extends Page {

    @FindBy (id = "mattName")
    WebElement calendarnameField;

    @FindBy (id = "next")
    WebElement nextButton;

    @FindBy (id = "back")
    WebElement backButton;

    @FindBy (id = "saveMatt")
    WebElement homeButton;

    public ViewCalendarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyCalendarName(String createdCalendarTxt){
        verifyText(createdCalendarTxt, calendarnameField);
    }

    public void clickNextButton() {
        clickElement(nextButton);
    }

    public void clickBackButton() {
        clickElement(backButton);
    }

    public void clickHomeButton() {
        clickElement(homeButton);
    }
}
