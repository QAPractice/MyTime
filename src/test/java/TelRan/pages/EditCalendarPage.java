package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

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

        @FindBy(xpath = "//*[@id='first']/div[1]/p")
        WebElement lableCalendarName;


        public EditCalendarPage(WebDriver driver){

                super(driver);
                this.PAGE_URL = "http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/action_edit?table=993&username=romankotlr%40gmail.com&993.x=14&993.y=10";
                PageFactory.initElements(driver, this);

        }

        public void waitUntilEditPageIsLoaded() {
                try {
                        waitUntilElementIsLoaded(lableCalendarName);
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

        }
        public void setStartDate(String month, int day) {
                clickElement(startDateLink);
                selectValueInDropdown(chooseMonth, month);
                clickElement(chooseStartDate);
        }

        public void setEndDate(String month, int day) {
                clickElement(endDateLink);
                selectValueInDropdown(chooseMonth, month);
                clickElement(chooseEndDate);
        }

        public void setTimeSlot(String timeSlot) {

                clickElement(timeSlotLink);
            selectValueInDropdown(choosetimeSlot, timeSlot);
        }
        public void openEditPage() {

                driver.get(PAGE_URL);
        }
        public boolean isOnEditPage() {
        return exists(nextButton);
    }

        public void setRepeatField(){

                clickElement(repeatField);
        }

        public void saveCalendar(){

                clickElement(saveButton);
        }

}


