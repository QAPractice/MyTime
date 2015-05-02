package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by OlgaK on 4/17/15.
 */
public class CreateCalendarOlgaPage extends Page {



    @FindBy (id ="mattName")
    WebElement calendarnameField;

    @FindBy (id = "startDate")
    WebElement startdateLink;

    @FindBy (xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a")
    WebElement chooseStartDate;

    @FindBy (id = "endDate")
    WebElement enddateLink;

    @FindBy (xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td[7]/a")
    WebElement chooseEndDate;

    @FindBy(xpath = "//select[@class='ui-datepicker-month'][@data-handler='selectMonth']")
    WebElement chooseMonth;

    @FindBy (id = "timeSlot")
    WebElement choosetimeSlotLink;

    @FindBy (id = "td1s4")
    WebElement chooseTime1;

    @FindBy (id = "td2s4")
    WebElement chooseTime2;

    @FindBy (id = "td3s4")
    WebElement chooseTime3;

    @FindBy (id = "saveMatt")
    WebElement saveButton;



    public CreateCalendarOlgaPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeCalendarName(String calendarName) {
        setElementText(calendarnameField, calendarName);
    }

    public void setStartDate(String month, String day) {
        clickElement(startdateLink);
        selectValueInDropdown(chooseMonth, month);

    }

    public void setTimeSlot(){
        clickElement(choosetimeSlotLink);
    }

    public void saveCalendar(){
        clickElement(saveButton);
    }

}

