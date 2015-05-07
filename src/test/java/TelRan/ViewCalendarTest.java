package TelRan;

import TelRan.pages.ViewCalendarPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void testVievCalendarPage() {
        try {
            viewCalendarPage.waitUntilViewCalendarPageIsLoaded();
            viewCalendarPage.verifyCalendarName(viewCalendarPage.getCalendarnameField().getText());
        } catch (Exception e) {

        }
    }
}

