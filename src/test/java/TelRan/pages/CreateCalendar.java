package TelRan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * Created by alex on 4/17/2015.
 */

public class CreateCalendar  extends Page {
   // protected WebDriver driver;
    // Calendar's name field
    @FindBy (id ="mattName")
    WebElement calendarNameField;

    @FindBy (id = "startDate")
    WebElement startDateSelect;

    @FindBy (id = "endDate")
    WebElement endDateSelect;

    @FindBy (id = "timeSlot")
    WebElement timeSlotSelect;

    @FindBy (id = "mRepeat")
    WebElement repeatWindow;

    @FindBy (id = "saveMatt")
    WebElement saveButton;

    @FindBy(xpath = "//select[@class='ui-datepicker-month'][@data-handler='selectMonth']")
    WebElement chooseMonth;

    @FindBy(xpath ="//*[@id='ui-datepicker-div']/div/div/span")
    WebElement setYear;

    @FindBy(xpath ="//*[@id='ui-datepicker-div']/div/a[2]/span")
    WebElement yearStepUp;

    @FindBy(xpath ="//*[@id='ui-datepicker-div']/div/a[1]/span")
    WebElement yearStepDown;

   // There are XPath for each date in calendar from 1 to 31.
    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'1') and not( contains(text(),'10') ) " +
            "and not( contains(text(),'11') ) and not( contains(text(),'12') ) and not( contains(text(),'13') )" +
            "and not( contains(text(),'14') ) and not( contains(text(),'15') ) and not( contains(text(),'16') ) " +
            "and not( contains(text(),'17') ) and not( contains(text(),'18') )and not( contains(text(),'19') )" +
            "and not( contains(text(),'21') ) and not( contains(text(),'31') ) ]")
    WebElement dayChooser_1;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'2') and not( contains(text(),'12') ) " +
            "and not( contains(text(),'20') ) and not( contains(text(),'21') ) and not( contains(text(),'22') )" +
            "and not( contains(text(),'23') ) and not( contains(text(),'24') ) and not( contains(text(),'25') ) " +
            "and not( contains(text(),'26') ) and not( contains(text(),'27') )and not( contains(text(),'28') )" +
            "and not( contains(text(),'29') )  ]")
    WebElement dayChooser_2;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'3') and not( contains(text(),'13') ) " +
            "and not( contains(text(),'23') ) and not( contains(text(),'30') ) and not( contains(text(),'31') ) ]")
    WebElement dayChooser_3;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'4') and not( contains(text(),'14') ) " +
            "and not( contains(text(),'24') )  ]")
    WebElement dayChooser_4;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'5') and not( contains(text(),'15') ) " +
            "and not( contains(text(),'25') )  ]")
    WebElement dayChooser_5;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'6') and not( contains(text(),'16') ) " +
            "and not( contains(text(),'26') )  ]")
    WebElement dayChooser_6;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'7') and not( contains(text(),'17') ) " +
            "and not( contains(text(),'27') )  ]")
    WebElement dayChooser_7;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'8') and not( contains(text(),'18') ) " +
            "and not( contains(text(),'28') )  ]")
    WebElement dayChooser_8;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'9') and not( contains(text(),'19') ) " +
            "and not( contains(text(),'29') )  ]")
    WebElement dayChooser_9;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'10')]")
    WebElement dayChooser_10;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'11')]")
    WebElement dayChooser_11;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'12')]")
    WebElement dayChooser_12;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'13')]")
    WebElement dayChooser_13;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'14')]")
    WebElement dayChooser_14;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'15')]")
    WebElement dayChooser_15;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'16')]")
    WebElement dayChooser_16;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'17')]")
    WebElement dayChooser_17;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'18')]")
    WebElement dayChooser_18;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'19')]")
    WebElement dayChooser_19;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'20')]")
    WebElement dayChooser_20;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'21')]")
    WebElement dayChooser_21;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'22')]")
    WebElement dayChooser_22;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'23')]")
    WebElement dayChooser_23;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'24')]")
    WebElement dayChooser_24;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'25')]")
    WebElement dayChooser_25;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'26')]")
    WebElement dayChooser_26;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'27')]")
    WebElement dayChooser_27;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'28')]")
    WebElement dayChooser_28;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'29')]")
    WebElement dayChooser_29;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'30')]")
    WebElement dayChooser_30;

    @FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody//a[contains(text(),'31')]")
    WebElement dayChooser_31;


    public CreateCalendar(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }

    // Month must be string from "0" to "11"(as defined by html code), day must be number from 1 to 31.
    public void setStartDate(int year, String month, int day) {
        WebElement dayChooser;
        String currentYear; // Year that is given by default

        clickElement(startDateSelect);
            // Here we are choosing year
        currentYear = setYear.getAttribute("textContent");
        int currentYearNumber = Integer.parseInt(currentYear);
        // System.out.println("setYear" + currentYearNumber);
        if( year - currentYearNumber > 0 )
            for (int i = 1;  i <= (year - currentYearNumber)*12; i++){  clickElement(yearStepUp); }
        if( year - currentYearNumber < 0 )
            for (int i = 1;  i <= (currentYearNumber - year)*12; i++){  clickElement(yearStepDown); }

        selectValueInDropdown(chooseMonth, month); // Here we are choosing month

        switch (day) {          // Here we are choosing day
            case 1: dayChooser = dayChooser_1;
                break;
            case 2: dayChooser = dayChooser_2;
                break;
            case 3: dayChooser = dayChooser_3;
                break;
            case 4: dayChooser = dayChooser_4;
                break;
            case 5: dayChooser = dayChooser_5;
                break;
            case 6: dayChooser = dayChooser_6;
                break;
            case 7: dayChooser = dayChooser_7;
                break;
            case 8: dayChooser = dayChooser_8;
                break;
            case 9: dayChooser = dayChooser_9;
                break;
            case 10: dayChooser = dayChooser_10;
                break;
            case 11: dayChooser = dayChooser_11;
                break;
            case 12: dayChooser = dayChooser_12;
                break;
            case 13: dayChooser = dayChooser_13;
                break;
            case 14: dayChooser = dayChooser_14;
                break;
            case 15: dayChooser = dayChooser_15;
                break;
            case 16: dayChooser = dayChooser_16;
                break;
            case 17: dayChooser = dayChooser_17;
                break;
            case 18: dayChooser = dayChooser_18;
                break;
            case 19: dayChooser = dayChooser_19;
                break;
            case 20: dayChooser = dayChooser_20;
                break;
            case 21: dayChooser = dayChooser_21;
                break;
            case 22: dayChooser = dayChooser_22;
                break;
            case 23: dayChooser = dayChooser_23;
                break;
            case 24: dayChooser = dayChooser_24;
                break;
            case 25: dayChooser = dayChooser_25;
                break;
            case 26: dayChooser = dayChooser_26;
                break;
            case 27: dayChooser = dayChooser_27;
                break;
            case 28: dayChooser = dayChooser_28;
                break;
            case 29: dayChooser = dayChooser_29;
                break;
            case 30: dayChooser = dayChooser_30;
                break;
            case 31: dayChooser = dayChooser_31;
                break;
            default: { System.out.println(" Such day is not exist" ); return; }
        }
        // Sleep added only for debugging
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickElement(dayChooser);
        // Sleep added only for debugging
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Month must be string from "0" to "11", day must be number from 1 to 31.
    public void setEndDate(int year, String month, int day) {
        WebElement dayChooser;
        String currentYear; // Year that is given by default

        clickElement(endDateSelect);
                         // Here we are choosing year
        currentYear = setYear.getAttribute("textContent");
        int currentYearNumber = Integer.parseInt(currentYear);
        // System.out.println("setYear" + currentYearNumber);
        if( year - currentYearNumber > 0 )
            for (int i = 1;  i <= (year - currentYearNumber)*12; i++){  clickElement(yearStepUp); }
        if( year - currentYearNumber < 0 )
            for (int i = 1;  i <= (currentYearNumber - year)*12; i++){  clickElement(yearStepDown); }

        selectValueInDropdown(chooseMonth, month); // Here we are choosing month

        switch (day) {          // Here we are choosing day
            case 1:
                dayChooser = dayChooser_1;
                break;
            case 2:
                dayChooser = dayChooser_2;
                break;
            case 3:
                dayChooser = dayChooser_3;
                break;
            case 4:
                dayChooser = dayChooser_4;
                break;
            case 5:
                dayChooser = dayChooser_5;
                break;
            case 6:
                dayChooser = dayChooser_6;
                break;
            case 7:
                dayChooser = dayChooser_7;
                break;
            case 8:
                dayChooser = dayChooser_8;
                break;
            case 9:
                dayChooser = dayChooser_9;
                break;
            case 10:
                dayChooser = dayChooser_10;
                break;
            case 11:
                dayChooser = dayChooser_11;
                break;
            case 12:
                dayChooser = dayChooser_12;
                break;
            case 13:
                dayChooser = dayChooser_13;
                break;
            case 14:
                dayChooser = dayChooser_14;
                break;
            case 15:
                dayChooser = dayChooser_15;
                break;
            case 16:
                dayChooser = dayChooser_16;
                break;
            case 17:
                dayChooser = dayChooser_17;
                break;
            case 18:
                dayChooser = dayChooser_18;
                break;
            case 19:
                dayChooser = dayChooser_19;
                break;
            case 20:
                dayChooser = dayChooser_20;
                break;
            case 21:
                dayChooser = dayChooser_21;
                break;
            case 22:
                dayChooser = dayChooser_22;
                break;
            case 23:
                dayChooser = dayChooser_23;
                break;
            case 24:
                dayChooser = dayChooser_24;
                break;
            case 25:
                dayChooser = dayChooser_25;
                break;
            case 26:
                dayChooser = dayChooser_26;
                break;
            case 27:
                dayChooser = dayChooser_27;
                break;
            case 28:
                dayChooser = dayChooser_28;
                break;
            case 29:
                dayChooser = dayChooser_29;
                break;
            case 30:
                dayChooser = dayChooser_30;
                break;
            case 31:
                dayChooser = dayChooser_31;
                break;
            default: {
                System.out.println(" Such day is not exist");
                return;
            }
        }
        // Sleep added only for debugging
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(dayChooser);
        // Sleep added only for debugging
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
// Builds XPath of element with 'calName' name and clicks on it.
    public void clickByXPath( String before, String calName, String after ){
        String xPath = before + calName + after;
        // Sleep added only for debugging
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(xPath)).click();
    }
// Chooses random name for calendar and returns it. Parameter n is a number of symbols in name.
    public String setRandomName( int n ){
        String Name = randomAlphabetic(n);
        setElementText(calendarNameField, Name);
        return Name;
     }

    public String setNotRandomName( String Name ){
        setElementText(calendarNameField, Name);
        return Name;
    }

    public void clickSaveButton(  ){
        clickElement(saveButton);
    }

    public void setTimeSlot(String value){
        selectValueInDropdown(timeSlotSelect, value);
    }

    public void waitUntilNameIsLoaded() {
       try {
           waitUntilElementIsLoaded(calendarNameField);
       } catch (IOException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

   }

}
