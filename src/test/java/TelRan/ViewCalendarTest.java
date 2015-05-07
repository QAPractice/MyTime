package TelRan;

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

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        viewCalendarPage = PageFactory.initElements(driver, ViewCalendarPage.class);
        viewCalendarPage.openViewCalendarPage();

    }

    @Test
    public void testViewCalendarPage() {
        try {
            viewCalendarPage.waitUntilViewCalendarPageIsLoaded();
            viewCalendarPage.isOnViewCalendarPage();
            String day = viewCalendarPage.getDayValue().getText();
            int prevDay = viewCalendarPage.getDayAsNumber(day);
            viewCalendarPage.setPrevLocatorValue(prevDay);
            viewCalendarPage.clickNextButton();
            String day2 = viewCalendarPage.getDayValue().getText();
            int nextDay = viewCalendarPage.getDayAsNumber(day2);
            viewCalendarPage.setNextLocatorValue(nextDay);
            boolean isNextDayGood = prevDay < nextDay;
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




