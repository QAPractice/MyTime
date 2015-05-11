package TelRan;

import TelRan.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Л on 5/10/2015.
 */
public class SendInvPOTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    LoginPage loginPage;
    MainPage mainPage;
    EmailPage emailPage;
    InvitationPage invitationPage;


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
        emailPage = PageFactory.initElements(driver, EmailPage.class);
        invitationPage = PageFactory.initElements(driver, InvitationPage.class);
    }

    @Test
    public void TestSendInvSuccess() {

        mainPage.waitUntilMainPageIsLoaded();
        assertTrue(mainPage.isOnMainPage());
        String name = mainPage.getCalendarName();
        mainPage.clickCollaboration();
        mainPage.clickSendInvitation();
        emailPage.typeEmail("rilopatin@gmail.com");
        emailPage.clickAdd();
        emailPage.clickSend();
        mainPage.waitUntilMainPageIsLoaded();
        assertTrue(mainPage.isOnMainPage());
        mainPage.clickInvitation();
        invitationPage.waitUntilMainPageIsLoaded();
        assertTrue(invitationPage.isOnInvitationPage());
        assertTrue(invitationPage.isInvitationNamePresents(name));

    }
}