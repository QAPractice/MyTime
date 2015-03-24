package TelRan;

    import java.util.concurrent.TimeUnit;
    import org.testng.*;
    import org.openqa.selenium.*;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    import static org.testng.Assert.assertEquals;
    import static org.testng.Assert.fail;
    import static org.testng.AssertJUnit.assertTrue;

public class CreateCaledar10enOleg {
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
    public void testCreateCaledar10enOleg_TC1342() throws Exception {
        driver.get(baseUrl + "/myavailabletime/home?name=romankotlr%40gmail.com&password=babylon1974");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//button[@onclick=\"form2.action='dom'\"]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//button[@onclick=\"form2.action='dom'\"]")).click();
        driver.findElement(By.id("mattName")).clear();
        driver.findElement(By.id("mattName")).sendKeys("one two three four five six seven eight nine ten");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("startDate"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("startDate")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td[2]/a")).click();
        driver.findElement(By.id("endDate")).click();
        driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[4]/td/a")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("saveMatt"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("saveMatt")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//*[contains(text(),\"one two three four five six seven eight nine ten\")]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.xpath("//*[contains(text(),\"one two three four five six seven eight nine ten\")]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        // ERROR: Caught exception [unknown command []]
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

