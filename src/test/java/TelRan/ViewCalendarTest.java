package TelRan;

import TelRan.pages.LoginPage;
import TelRan.pages.MainPage;
import TelRan.pages.ViewCalendarPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Marina on 5/7/2015.
 */
public class ViewCalendarTest {
    public WebDriver driver;
    public WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private ViewCalendarPage viewCalendarPage;
    private LoginPage loginPage;
    private MainPage mainPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        loginPage.openLoginPage();

    }

    @Test
    public void testViewCalendarPage() {
        try {
            loginPage.login("romankotlr@gmail.com", "babylon1974");
            mainPage.waitUntilMainPageIsLoaded();
            mainPage.clickVievButton();
            viewCalendarPage.waitUntilViewCalendarPageIsLoaded();
            viewCalendarPage.isOnViewCalendarPage();

            String day = viewCalendarPage.getDayValue().getText();
            Date prevDay = viewCalendarPage.getDateFromString(day);
            viewCalendarPage.setPrevLocatorValue(prevDay);

            viewCalendarPage.clickNextButton();

            String day2 = viewCalendarPage.getDayValue().getText();
            Date nextDay = viewCalendarPage.getDateFromString(day2);
            viewCalendarPage.setNextLocatorValue(nextDay);
            boolean isNextDayGood = viewCalendarPage.getPrevLocatorValue().before(viewCalendarPage.getNextLocatorValue()); //prevDay.before(nextDay);
            Assert.assertTrue(isNextDayGood);

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




