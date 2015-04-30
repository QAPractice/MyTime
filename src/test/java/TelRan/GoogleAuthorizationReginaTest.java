package TelRan;


        import java.util.Iterator;
        import java.util.Set;
        import java.util.concurrent.TimeUnit;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.firefox.FirefoxProfile;
        import org.openqa.selenium.firefox.internal.ProfilesIni;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

        import static org.testng.Assert.assertTrue;
        import static org.testng.Assert.fail;

public class GoogleAuthorizationReginaTest {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeTest
        public void setUp() throws Exception {
 //---create the WebDriver with the default values
            FirefoxProfile profile =  new ProfilesIni().getProfile("default");
            driver = new FirefoxDriver(profile);
 //-----------------------------------------------
            baseUrl = "http://myavailabletime.com/";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testGoogleAuthorization() throws Exception {
            driver.get("http://ec2-54-166-51-117.compute-1.amazonaws.com:8080/myavailabletime/home?name=rilopatin%40gmail.com&password=12345&mergedimage_2=");
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//button[@type='submit']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//button[@type='submit']")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//div[@id='___signin_0']/button"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//div[@id='___signin_0']/button")).click();
 //---change Window to "Запрос на разрешение"
            Set<String> setWindowsId= driver.getWindowHandles();
            Iterator<String> str = setWindowsId.iterator();
            String parentId = str.next();
            String childId = str.next();
            driver.switchTo().window(childId);
 //-------------------------------------------
            // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | Запрос на разрешение | ]]
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.id("submit_approve_access"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.id("submit_approve_access")).click();
 //---change Window to "Account settings"
            driver.switchTo().window(parentId);
 //---------------------------------------
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='googlecheck']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            try {
                assertTrue(driver.findElement(By.xpath("//*[@id='googlecheck']")).isDisplayed());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.id("savebutton")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//*[@id='first']"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            try {
                assertTrue(isElementPresent(By.xpath("//*[@id='first']")));
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
