package TelRan;

    import org.openqa.selenium.*;
    import org.openqa.selenium.firefox.FirefoxDriver;
    import org.testng.*;
    import org.testng.annotations.AfterTest;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Test;

    import java.util.concurrent.TimeUnit;

    import static org.testng.Assert.assertTrue;
    import static org.testng.Assert.fail;

public class Login1RegTest {
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
        public void testLoginGood_TC1338() throws Exception {
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
