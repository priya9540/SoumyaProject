package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    private WebDriver driver;

    public Wrappers(WebDriver driver) {
        this.driver = driver;
    }

    // Wrapper method to click on a WebElement
    public void click(WebElement element)throws InterruptedException {
        try {
            element.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error clicking on element: " + e.getMessage());
        }
    }

    // Wrapper method to send keys to a WebElement
    public void sendKeys(WebElement element, String text) {
        try {
            element.clear(); // Clear the field before entering text
            element.sendKeys(text);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error sending keys to element: " + e.getMessage());
        }
    }
    public void sendKeysWithEpochTime(WebElement element, String text){
        long epochTime = System.currentTimeMillis() / 1000;
        String NewString = text + epochTime;
        try {
            element.clear(); // Clear the field before entering text
            element.sendKeys(NewString);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error sending keys to element: " + e.getMessage());
        }

    }
    public void checkbox(WebElement element) throws InterruptedException{
        if (!element.isSelected()) {  // Check if the checkbox is not already selected
            element.click();
            Thread.sleep(2000);
    }
    }
    
    
    public void getText(WebElement element)  {
        if(element.isDisplayed()){
            String ElementText=element.getText();
        
            System.out.println("Success message Displayed  "+ElementText);
        }
        else{
            System.out.println("Element not displayed");
        }
    }
    }

