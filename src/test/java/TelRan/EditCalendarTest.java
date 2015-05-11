package TelRan;

import TelRan.pages.EditCalendarPage;
import TelRan.pages.LoginPage;
import TelRan.pages.MainPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Iakov Volf, Oleg on 5/4/2015.
 */
public class EditCalendarTest {

    public WebDriver driver;
    public WebDriverWait wait;
    LoginPage loginPage;
    EditCalendarPage editCalendarPage;
    MainPage mainPage;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage.openLoginPage();
        try {
            loginPage.login("telrantests@yahoo.com", "12345.com");
            mainPage.waitUntilMainPageIsLoaded();
            mainPage.clickToEditButtonFirstCal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestEditPageSuccess() {
        try {
            editCalendarPage.waitUntilEditPageIsLoaded();
            editCalendarPage.checkCalendarNameIsCorrect("CalendarFirst");
            editCalendarPage.setStartDate(2015,"5", 11);
          //  editCalendarPage.setEndDate("8","8");
            editCalendarPage.setTimeSlot("30");
            editCalendarPage.setRepeatField();
            editCalendarPage.saveCalendar();
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

