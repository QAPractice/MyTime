package TelRan;

/**
 * Created by alex on 3/25/2015.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.FileAssert.fail;

public class TR_329_Login_Create_Edit__Kalugin_Alex {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String Name ;


    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://myavailabletime.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

// *******************************************************************************************************
                          //  First test case: LOGIN to myAvailableTime
// *******************************************************************************************************

     @Test
    public void testTC1338LoginThroughYahooAcc() throws Exception {
        driver.get(baseUrl + "/");
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

        driver.findElement(By.id("polelogin")).clear();
        driver.findElement(By.id("polelogin")).sendKeys("telrantests@yahoo.com");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("password"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345.com");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("1"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("1")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("second"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.id("second")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Logins succesfully into account");
    }

// *******************************************************************************************************
                   //  Second test case: Create-Edit Calendar
// *******************************************************************************************************

    @Test
    public void testTC1339CreateCalendar() throws Exception {
  /*      driver.get(baseUrl + "/myavailabletime/home?name=telrantests%40yahoo.com&password=12345.com");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//button[@onclick=\"form2.action='dom'\"]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
*/
        driver.findElement(By.xpath("//button[@onclick=\"form2.action='dom'\"]")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("mattName"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        Name = random(1);
        System.out.println("Generated name - " + Name);
        driver.findElement(By.id("mattName")).click();
        driver.findElement(By.id("mattName")).clear();
        driver.findElement(By.id("mattName")).sendKeys(Name);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("timeSlot"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        System.out.println("Where am I N1?");

        new Select(driver.findElement(By.id("timeSlot"))).selectByVisibleText("1 hour");
        driver.findElement(By.id("saveMatt")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Calendar '" + Name + "' with 1 hour slot was created");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]/../../tr[3]/td[2]/input"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        System.out.println("Presses on 'Edit' button under Calendar '" + Name + "' link.");
        driver.findElement(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]/../../tr[3]/td[2]/input")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("timeSlot"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertFalse(isElementPresent(By.id("td24s0")));
        System.out.println("Verifiiyint that previous slot is for 1 hour");
        new Select(driver.findElement(By.id("timeSlot"))).selectByVisibleText("30 min");
        System.out.println("Changing time slot is to 30 min");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("td24s0"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.id("td24s0")));
        assertFalse(isElementPresent(By.id("td48s0")));
        driver.findElement(By.id("saveMatt")).click();
        System.out.println("Presses on 'View' button under Calendar '" + Name + "' link.");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]/../../tr[3]/td[1]/input"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]/../../tr[3]/td[1]/input")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("mattTable"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        System.out.println("Verifies that selected time slot is still 30 minutes");
        try {
            assertTrue(isElementPresent(By.id("td47s0")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertFalse(isElementPresent(By.id("td95s0")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.id("saveMatt")).click();
        System.out.println("Deleting Calendar " + Name);
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]/../../tr[3]/td[8]/input"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]/../../tr[3]/td[8]/input")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (!isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertFalse(isElementPresent(By.xpath("//*[@id='placetable']//tr[1]/td[contains(text(), '" + Name + "')]")));
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
