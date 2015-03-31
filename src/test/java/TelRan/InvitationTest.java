package TelRan;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import TelRan.LoginOlgaK;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class InvitationTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    LoginOlgaK loginOlgaK = new LoginOlgaK();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
        public void testClickInv() throws Exception {
        //loginOlgaK.testLoginOlgaK();
        driver.get(baseUrl + "/myavailabletime/home?name=romankotlr%40gmail.com&password=babylon1974&mergedimage_2=");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='first']/div/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(driver.findElement(By.xpath("//*[@id='first']/div/p")).getText().matches("^[\\s\\S]*Invitations$"));
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
}
