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

    @FindBy(xpath = "//*[@id='placetable']//tr[3]/td[contains(text(),'CalendarFirst')]/input")  // REMOVE
            WebElement calendarFirstRemoveButton;

    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4486432')]/../../tr[3]/td[3]/a")
    WebElement digitshareButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4486432')]/../../tr[4]/td[2]/input")
    WebElement digitshareMailButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4486432')]/../../tr[4]/td[3]/a")
    WebElement digitshareOnGoogleButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4486432')]/../../tr[4]/td[4]/a")
    WebElement digitshareOnFacebookButton;

    @FindBy(xpath = "//*[@id='placetable']//tr[3]/td[contains(text(),'4486432')]/input")  // REMOVE
            WebElement calendarDigitRemoveButton;

    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4482Second')]/../../tr[3]/td[3]/a")
    WebElement digitLettershareButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4482Second')]/../../tr[4]/td[2]/input")
    WebElement digitLettershareMailButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4482Second')]/../../tr[4]/td[3]/a")
    WebElement digitLettershareOnGoogleButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'4482Second')]/../../tr[4]/td[4]/a")
    WebElement digitLettershareOnFacebookButton;

    @FindBy(xpath = "//*[@id='placetable']//tr[3]/td[contains(text(),'4482Second')]/input")  // REMOVE
            WebElement calendarSecondRemoveButton;

    @FindBy(xpath = "//*[@id='form2']/div/button")   // CREATE A NEW AVAILABLE CALENDAR
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

    public void clickToShareMailButtonSecondCal() {
        clickElement(digitshareMailButton);
        EmailAddressPage emailAddressPage;
        emailAddressPage = PageFactory.initElements(driver, EmailAddressPage.class);
    }

    public void clickToShareOnGoogleButtonFirstCal() {
        clickElement(calendarFirstshareOnGoogleButton);
        SyncGooglePage syncCooglePage;
        syncCooglePage = PageFactory.initElements(driver, SyncGooglePage.class);
    }

    public void clickToShareOnGoogleButtonDigitCal() {
        clickElement(digitshareOnGoogleButton);
        SyncGooglePage syncCooglePage;
        syncCooglePage = PageFactory.initElements(driver, SyncGooglePage.class);
    }

    public void clickToShareOnGoogleButtonSecondCal() {
        clickElement(digitLettershareOnGoogleButton);
        SyncGooglePage syncCooglePage;
        syncCooglePage = PageFactory.initElements(driver, SyncGooglePage.class);
    }

    public void clickToShareOnFacebookButtonFirstCal() {
        clickElement(calendarFirstshareOnFacebookButton);
        SyncFacebookPage syncFacebookPage;
        syncFacebookPage = PageFactory.initElements(driver, SyncFacebookPage.class);
    }

    public void clickToShareOnFacebookButtonDigitCal() {
        clickElement(digitshareOnFacebookButton);
        SyncFacebookPage syncFacebookPage;
        syncFacebookPage = PageFactory.initElements(driver, SyncFacebookPage.class);
    }

    public void clickToShareOnFacebookButtonSecondCal() {
        clickElement(digitLettershareOnFacebookButton);
        SyncFacebookPage syncFacebookPage;
        syncFacebookPage = PageFactory.initElements(driver, SyncFacebookPage.class);
    }

}
 
