package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

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

    private int prevLocatorValue;

    public ViewCalendarPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/viewMatt?table=993&username=romankotlr%40gmail.com&993.x=16&993.y=17";
        PageFactory.initElements(driver, this);
    }

    public void waitUntilViewCalendarPageIsLoaded() {
        try {
            waitUntilElementIsLoaded(calendarnameField);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openViewCalendarPage() {
        driver.get(PAGE_URL);
    }

    public boolean isOnViewCalendarPage() {
        return PAGE_URL.contains("viewMatt");
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


    private int getDayAsNumber(String date) {
        String s = date.substring(0, date.indexOf('.'));
        int number = Integer.parseInt(s);
        return number;
    }

    public WebElement getCalendarnameField() {
        return calendarnameField;
    }
}
