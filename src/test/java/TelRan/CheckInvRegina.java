package TelRan;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class CheckInvRegina {
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
    public void testCheckInvReg() throws Exception {
        driver.get("http://myavailabletime.com/");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.linkText("Login to MyAvailableTime"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.linkText("Login to MyAvailableTime")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("polelogin"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        System.out.println("Type login");
        driver.findElement(By.id("polelogin")).click();
        driver.findElement(By.id("polelogin")).clear();
        driver.findElement(By.id("polelogin")).sendKeys("ri-lopatina@yandex.ru");
        System.out.println("Type password");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("1")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("second"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        System.out.println("check invitation");
        driver.findElement(By.xpath("//*[@id='log']/span[5]/button")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='first']/div[1]/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[contains(text(),\"Initiator name\")]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[contains(text(),\"Initiator name\")]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//*[contains(text(),\"Initiator name\")]")).click();
        System.out.println("Choose time");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='first']/div[1]/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='td47s4']")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertFalse(isElementPresent(By.xpath("//*[@id='td48s4']")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//*[@id='td2s4']")).click();
        driver.findElement(By.xpath("//*[@id='saveMatt']")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='first']/div/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertFalse(isElementPresent(By.xpath("//*[contains(text(),\"Initiator name\")]")));
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
