package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by oshil on 03.05.2015.
 */
public class EditCalendarPage extends Page{

        @FindBy(id="saveMatt")
        WebElement saveButton;

        @FindBy(id="mRepeat")
        WebElement repeatField;

        @FindBy(id="timeSlot")
        WebElement timeSlotLink;

        @FindBy(id="startDate")
        WebElement startDateLink;

        @FindBy(id="endDate")
        WebElement endDateLink;

        @FindBy (xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[4]/a")
        WebElement chooseStartDate;

        @FindBy (xpath = "//div[@id='ui-datepicker-div']/table/tbody/tr[3]/td[3]/a")
        WebElement chooseEndDate;

        @FindBy(xpath = "//select[@class='ui-datepicker-month'][@data-handler='selectMonth']")
        WebElement chooseMonth;

        @FindBy(xpath = "//select[@id='timeSlot'][@name='timeSlot']")
        WebElement choosetimeSlot;


        @FindBy(id="next")
        WebElement nextButton;

        @FindBy(id="back")
        WebElement backButton;

        public EditCalendarPage(WebDriver driver){

                super(driver);
                PageFactory.initElements(driver, this);

        }

        public void setStartDate(String month, String day) {
                clickElement(startDateLink);
                selectValueInDropdown(chooseMonth, month);
                clickElement(chooseStartDate);
        }

        public void endStartDate(String month, String day) {
                clickElement(endDateLink);
                selectValueInDropdown(chooseMonth, month);
                clickElement(chooseEndDate);
        }

        public void setTimeSlot(String timeSlot){

                clickElement(timeSlotLink);
                selectValueInDropdown(choosetimeSlot,timeSlot);
        }

        public void setRepeatField(){

                clickElement(repeatField);
        }

        public void saveCalendar(){

                clickElement(saveButton);
        }

}


