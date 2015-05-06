package TelRan;

import TelRan.pages.LoginPage;
import TelRan.pages.MainPage;
import TelRan.pages.EditCalendarPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Iakov Volf on 5/4/2015.
 */
public class EditCalendarTest {

    public WebDriver driver;
    public WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    EditCalendarPage editCalendarPage;
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        editCalendarPage = PageFactory.initElements(driver, EditCalendarPage.class);
        editCalendarPage.openEditPage();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void TestLoginSuccess() {
        try {
            editCalendarPage.waitUntilEditPageIsLoaded();
            editCalendarPage.setStartDate("May",11);
            editCalendarPage.setEndDate("Jun",8);
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

