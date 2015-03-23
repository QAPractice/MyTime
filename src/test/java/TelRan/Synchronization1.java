package TelRan;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;

public class Synchronization1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/";

              driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testSynchronization1() throws Exception {
        driver.get(baseUrl + "/myavailabletime/home?name=MyAvailableTime2015%40gmail.com&password=12345&mergedimage_2=");
        driver.findElement(By.xpath("//span[3]/button")).click();
        driver.findElement(By.xpath("//div[@id='___signin_0']/button")).click();
        String mainWindowID = driver.getWindowHandle();
        driver.switchTo().window("Запрос на разрешение");
            for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("submit_approve_access"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("submit_approve_access")).click();
        driver.close();
        driver.switchTo().window(mainWindowID);
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
}
