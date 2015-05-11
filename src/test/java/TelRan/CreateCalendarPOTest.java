package TelRan;

import TelRan.pages.CreateCalendarPage;
import TelRan.pages.MainPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by alex on 05/05/2015.
 */
public class CreateCalendarPOTest {

    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    CreateCalendarPage createCalendarPage;
    MainPage mainPage;


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        createCalendarPage = PageFactory.initElements(driver,CreateCalendarPage.class);
        editCalendarPage = PageFactory.initElements(driver, EditCalendarPage.class);
        loginPage.openLoginPage();
        try {
            loginPage.login("telrantests@yahoo.com", "12345.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPage.waitUntilMainPageIsLoaded();
    }


    @Test
    public void CreateCalendarTest() {
        String Name;
        try {
            mainPage.openMainPage();
            mainPage.createNewCalendar();
            createCalendarPage.waitUntilNameIsLoaded();
            Name = createCalendarPage.setNotRandomName("CalendarFirst");
            startDateValue = createCalendarPage.setStartDate(2012, "5", 8);
            endDateValue = createCalendarPage.setEndDate( 2017, "7", 2 );
            createCalendarPage.setTimeSlot("30");
            createCalendarPage.clickFirstCell( );
            createCalendarPage.clickSaveButton();
            mainPage.waitUntilMainPageIsLoaded();
            assertTrue(mainPage.isOnMainPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @AfterClass(alwaysRun = true)
    public void teardown() {
        this.driver.quit();
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
