package TelRan;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.testng.Assert.*;

public class CreateMATWithRepeatRegina {
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
    public void testCreateMATwithRepeat() throws Exception {
        driver.get("http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/home?name=rilopatin%40gmail.com&password=12345&mergedimage_2=");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='form2']/div/button"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='form2']/div/button")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("mattName"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        calendarName = random(7,true,false);
        System.out.println("New calendar Name");
        driver.findElement(By.id("mattName")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        driver.findElement(By.id("mattName")).clear();
        driver.findElement(By.id("mattName")).sendKeys(calendarName);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("mattName"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertEquals(calendarName, driver.findElement(By.id("mattName")).getAttribute("value"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Start date");
        driver.findElement(By.id("startDate")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a")).click();
        System.out.println("End date");
        driver.findElement(By.id("endDate")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td[7]/a")).click();
        System.out.println("Time slot");
        new Select(driver.findElement(By.id("timeSlot"))).selectByVisibleText("30 min");
        System.out.println("Set time");

        Thread.sleep(5000);

        driver.findElement(By.id("td1s4")).click();
        driver.findElement(By.id("td2s4")).click();
        driver.findElement(By.id("td3s4")).click();
        try {
            assertTrue(isElementPresent(By.id("td47s4")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertFalse(isElementPresent(By.id("td48s4")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Repeat");
        driver.findElement(By.xpath("//*[@id='mRepeat']")).click();
        try {
            assertTrue(driver.findElement(By.xpath("//*[@id='mRepeat']")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//*[@id='next']")).click();

            Thread.sleep(5000);
        System.out.println("step1");

        try {
            assertTrue(isElementPresent(By.id("td47s11")));
            System.out.println("step47");
        } catch (Error e) {
            System.out.println("step47err");
            verificationErrors.append(e.toString());
        }
        try {
            assertFalse(isElementPresent(By.id("td48s11")));
            System.out.println("step48");
        } catch (Error e) {
            System.out.println("step48err");
            verificationErrors.append(e.toString());
        }
        System.out.println("Save MAT");
        driver.findElement(By.id("saveMatt")).click();
        System.out.println("step2");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("/*//*[contains(text(),\"" + calendarName + "\")]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[contains(text(),\"" + calendarName + "\")]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // ERROR: Caught exception [unknown command []]
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
