package TelRan;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LogInSyncGoogleMarinaTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {

//        FirefoxProfile firefoxProfile = new FirefoxProfile(new File("C:\\Users\\Marina\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\dyb1lib7.default"));
//        driver = new FirefoxDriver(firefoxProfile);
//        FirefoxProfile firefoxProfile = getProfile();
        driver = new FirefoxDriver();
        baseUrl = "http://myavailabletime.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSync() throws Exception {
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Login to MyAvailableTime")).click();
        driver.findElement(By.id("polelogin")).clear();
        driver.findElement(By.id("polelogin")).sendKeys("MyAvailableTime2015@gmail.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("1")).click();
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.findElement(By.cssSelector("button")).click();

        // switch focus of WebDriver to the google login window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Запрос на разрешение | ]]
        //driver.get(baseUrl + "/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fauth%3Fzt%3DChRNZTNUa1F4WFZyeF9pcFRaOGFUbxIfa3M1b0NDdHNoTDhZb2lJQmVPNlAybV9lSU54NW1RSQ%25E2%2588%2599APsBz4gAAAAAVS5U8K0m7tg6k2LpsJYpxjRnEBhnazQ0%26from_login%3D1%26hl%3Dru%26e%3D3100077%26as%3D-26ea31c52bbf775f&shdf=Cn4LEhF0aGlyZFBhcnR5TG9nb1VybBoADAsSFXRoaXJkUGFydHlEaXNwbGF5TmFtZRoPTXlBdmFpbGFibGVUaW1lDAsSBmRvbWFpbhoPTXlBdmFpbGFibGVUaW1lDAsSFXRoaXJkUGFydHlEaXNwbGF5VHlwZRoHREVGQVVMVAwSA2xzbyIUHs8Ldks85An8gWpnOBtoU-pvN4UoATIU5u4oILHgJMTfjwYOqRlzP24xLyU&service=lso&ltmpl=popup&sarp=1");
        driver.findElement(By.id("Passwd")).clear();
        driver.findElement(By.id("Passwd")).sendKeys("myavailabletime");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("myavailabletime2015@gmail.com");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.id("submit_approve_access")).click();

        // close google login
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window

        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("savebutton"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("savebutton")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='form2']/div/button"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='form2']/div/button")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='second']/div/p[8]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
             assertEquals("myavailabletime2015@gmail.com", driver.findElement(By.xpath("//div[@id='second']/div/p[8]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
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

    private FirefoxProfile getProfile() {
        ProfilesIni profileini = new ProfilesIni() {
            @Override
            public FirefoxProfile getProfile(String profileName) {
                File appData = locateAppDataDirectory(Platform.getCurrent());
                Map<String, File> profiles = readProfiles(appData);
                File profileDir = profiles.get(profileName);
                if (profileDir == null)
                    return null;
                return new FirefoxProfile(profileDir);
            }
        };

        return profileini.getProfile("default");
    }
}
