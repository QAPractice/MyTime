package TelRan;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.FileAssert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.testng.Assert.fail;

public class Sync1Test {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://myavailabletime.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void syncTest1() throws Exception {
        driver.get("http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/home?name=MyAvailableTime2015%40gmail.com&password=12345&mergedimage_2=");
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//button[@type='submit']"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//div[@id='___signin_0']/button"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//div[@id='___signin_0']/button")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) FileAssert.fail("timeout");
            try {
                if (isElementPresent(By.xpath("//div[@id='Email']")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
        // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _blank | 30000]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Запрос на разрешение | ]]
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//div[@id='___signin_0']/button']")).click();
        // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        //driver.findElement(By.xpath("//div[@id='Email'")).sendKeys("myavailabletime2015@gmail.com");
//code to do something on new window
        driver.findElement(By.id("Passwd")).clear();
        driver.findElement(By.id("Passwd")).sendKeys("myavailabletime");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("myavailabletime2015@gmail.com");
        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.id("submit_approve_access")).click();
        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle);
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.id("submit_approve_access"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("submit_approve_access")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.id("savebutton"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("savebutton")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//*[@id='form2']/div/button"))) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//*[@id='form2']/div/button")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(By.xpath("//div[@id='second']/div/p[8]"))) break;
            } catch (Exception e) {
            }
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
