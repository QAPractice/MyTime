package TelRan;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class SetAppointmentReginaTest {
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
    public void testSetAppointment() throws Exception {
        driver.get("http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/home?name=rilopatin%40gmail.com&password=12345&mergedimage_2=");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']/table[1]/tbody/tr[3]/td[7]/a/img"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='placetable']/table[1]/tbody/tr[3]/td[7]/a/img")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='placetable']/table/tbody/tr[5]/td[7]/input"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='placetable']/table/tbody/tr[5]/td[7]/input")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='first']/div[1]/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='setAppoSave']")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='first']/div/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
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
