/**
 * Created by Anton on 24-Mar-15.
 */
package TelRan;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class CreateAntonTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String calendarName;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testCreateCalendarPositiveAnton() throws Exception {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//form[@id='form2']/div/button"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//form[@id='form2']/div/button")).click();
       calendarName = random(7);
        System.out.println("New calendar Name " + calendarName);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("mattName"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("mattName")).click();
        driver.findElement(By.id("mattName")).clear();
        driver.findElement(By.id("mattName")).sendKeys(calendarName);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("timeSlot"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        new Select(driver.findElement(By.id("timeSlot"))).selectByVisibleText("30 min");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("startDate"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("startDate")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//tr/td/a")).click();
        driver.findElement(By.id("endDate")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a/span")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//tr[4]/td[7]/a")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("saveMatt"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("saveMatt")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']/table"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(),'" + calendarName + "')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Calendar " + calendarName + " was created");
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

