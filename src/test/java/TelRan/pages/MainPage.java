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
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[3]/td[3]/a")
    WebElement shareButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[4]/td[2]/input")
    WebElement shareMailButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[4]/td[3]/a")
    WebElement shareOnGoogleButton;
    @FindBy(xpath = "//*[@id='placetable']//tr[1]/td[contains(text(),'MyCalendar')]/../../tr[4]/td[4]/a")
    WebElement shareOnFacebookButton;
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

    public void clickToShareButton() {
        clickElement(shareButton);
    }


}
