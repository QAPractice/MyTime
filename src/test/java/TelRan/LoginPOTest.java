package TelRan;

import TelRan.pages.LoginPage;
import TelRan.pages.MainPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class LoginPOTest {
    public WebDriver driver;
    public WebDriverWait wait;
    protected boolean acceptNextAlert = true;
    LoginPage loginPage;
    MainPage mainPage;


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        this.driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openLoginPage();
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }


    @Test
    public void TestLoginSuccess() {
        try {
            loginPage.waitUntilLoginPageIsLoaded();
            loginPage.fillLoginfields("romankotlr@gmail.com", "babylon1974");
            loginPage.clickToLogin();
            mainPage.waitUntilMainPageIsLoaded();
            assertTrue(mainPage.isOnMainPage());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void TestLoginUnsuccess() {
        try {
            loginPage.waitUntilLoginPageIsLoaded();
            loginPage.fillLoginfields("romankotlr@gmail.com", "babylon2014");
            loginPage.clickToLogin();
            mainPage.waitUntilMainPageIsLoaded();
            assertFalse(mainPage.isOnMainPage());

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
