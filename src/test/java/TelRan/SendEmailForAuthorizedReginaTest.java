package TelRan;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class SendEmailForAuthorizedReginaTest {
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
    public void testSendEmailForAuthorized() throws Exception {
        driver.get("http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/home?name=rilopatin%40gmail.com&password=12345&mergedimage_2=");
        driver.findElement(By.xpath("//div[@id='placetable']/table/tbody/tr[3]/td[7]/a/img")).click();
        driver.findElement(By.xpath("//*[@id='placetable']/table/tbody/tr[5]/td[6]/input")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='availableEmails']"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[@id='availableEmails']")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Choose email");
        new Select(driver.findElement(By.xpath("//*[@id='availableEmails']"))).selectByVisibleText("ri-lopatina@yandex.ru");
        driver.findElement(By.xpath("//input[@value='Add']")).click();
        try {
            assertEquals("ri-lopatina@yandex.ru", driver.findElement(By.xpath("//*[@id='sendEmails']")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        System.out.println("Send email");
        driver.findElement(By.xpath("//input[@value='Send']")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[@id='form2']/div/p"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//form[@id='log']/span/a")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//a"))) break; } catch (Exception e) {}
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

