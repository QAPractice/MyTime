package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alex Kaplan on 16.04.2015.
 * Editing of Calendar
 */

public class EditCalendarKaplan extends Page {

    @FindBy(id="saveMatt")
    WebElement saveButton;

    @FindBy(id="mRepeat")
    WebElement repeatField;

    @FindBy(id="timeSlot")
    WebElement timeSlotNenu;

    @FindBy(id="startDate")
    WebElement startDateButton;

    @FindBy(id="endDate")
    WebElement endDateButton;

    //I'm not sure in the correctness of this
    @FindBy(xpath="//*[@id='ui-datepicker-div']/div/div/select")
    WebElement selectMonthMenu;

    //I'm not sure in the correctness of this
    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody")
    WebElement selectDayMenu;

    @FindBy(id="next")
    WebElement nextButton;

    @FindBy(id="back")
    WebElement backButton;









 /*   @FindBy(id = "polelogin")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "1")
    WebElement loginButton;*/



    public EditCalendarKaplan(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);

    }




}
