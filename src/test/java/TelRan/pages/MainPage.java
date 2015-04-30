package TelRan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anton on 18-Apr-15, Iakov Volf,
 */
public class MainPage extends Page {

    //buttons Sharing
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'CalendarFirst')]/../../tr[3]/td[3]/a")
    WebElement calendarFirstshareButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'CalendarFirst')]/../../tr[4]/td[2]/input")
    WebElement calendarFirstshareMailButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'CalendarFirst')]/../../tr[4]/td[3]/a")
    WebElement calendarFirstshareOnGoogleButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'CalendarFirst')]/../../tr[4]/td[4]/a")
    WebElement calendarFirstshareOnFacebookButton;

    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4486432')]/../../tr[3]/td[3]/a")
    WebElement digitshareButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[4]/td[2]/input")
    WebElement digitshareMailButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[4]/td[3]/a")
    WebElement digitshareOnGoogleButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[4]/td[4]/a")
    WebElement digitshareOnFacebookButton;
    @FindBy(xpath = "//*[@id='form2']/div/button")
    WebElement linkToNewCalendar;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openNewCalendarPage() {
        clickElement(linkToNewCalendar);

        CreateCalendarOlgaPage createCalendarOlgaPage;
        createCalendarOlgaPage = PageFactory.initElements(driver, CreateCalendarOlgaPage.class);
    }

    public String getElementName(String calendarname, String buttonname) {
        return (calendarname + buttonname);
    }

    public void clickToShareButtonFirstCal() {
        clickElement(calendarFirstshareButton);
    }

    public void clickToShareButtonDigitCal() {
        clickElement(digitshareButton);
    }

    public void clickToShareMailButtonDigitCal() {
        clickElement(digitshareMailButton);
        EmailAddressPage emailAddressPage;
        emailAddressPage = PageFactory.initElements(driver, EmailAddressPage.class);

    }

    public void clickToShareMailButtonFirctCal() {
        clickElement(calendarFirstshareMailButton);
        EmailAddressPage emailAddressPage;
        emailAddressPage = PageFactory.initElements(driver, EmailAddressPage.class);

    }


}
 
