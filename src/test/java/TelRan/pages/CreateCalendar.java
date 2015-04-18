package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alex on 4/17/2015.
 */

public class CreateCalendar  extends Page {

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

    public CreateCalendar(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }

}
