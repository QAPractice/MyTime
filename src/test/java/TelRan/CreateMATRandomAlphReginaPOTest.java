package TelRan;

import TelRan.pages.CreateCalendarOlgaPage;
import TelRan.pages.CreateCalendarPage;
import TelRan.pages.LoginPage;
import TelRan.pages.MainPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Л on 5/6/2015.
 */
public class CreateMATRandomAlphReginaPOTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    LoginPage loginPage;
    MainPage mainPage;
    CreateCalendarPage createCalendarPage;

    @BeforeClass
    public void setup() throws Exception {
        this.driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openLoginPage();
        try {
            loginPage.login("rilopatin@gmail.com", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }
    @Test
    public void TestCreateMATSuccess() {
        try {
            mainPage.waitUntilMainPageIsLoaded();
            assertTrue(mainPage.isOnMainPage());
            mainPage.openNewCalendarPage();
            createCalendarPage = PageFactory.initElements(driver, CreateCalendarPage.class);
            String name = createCalendarPage.setRandomName(7);
            createCalendarPage.setStartDate(2016, "6", 16);
            createCalendarPage.setEndDate(2016, "6", 17);
            createCalendarPage.setTimeSlot("30");
            createCalendarPage.clickFirstCell();
            createCalendarPage.IsFirstCellGreenAfterClick();
            createCalendarPage.isSecondCellColorChangedAfterClick();
            createCalendarPage.clickSaveButton();
            assertTrue(mainPage.isOnMainPage());
            assertTrue(mainPage.isCalendarNamePresents(name));


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
