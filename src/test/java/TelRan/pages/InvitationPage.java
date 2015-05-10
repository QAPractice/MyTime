package TelRan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Л on 5/11/2015.
 */
public class InvitationPage extends Page{
    public InvitationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='log']/span[5]/button")
    WebElement homeButton;

    public boolean isOnInvitationPage() {
        return verifyTextBoolean("Home", homeButton);
    }
    public void waitUntilMainPageIsLoaded(){
        try {
            waitUntilElementIsLoaded(homeButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isInvitationNamePresents(String name){
        try {
            driver.findElement(By.xpath("//*[contains(text(),\"" + name + "\")]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
