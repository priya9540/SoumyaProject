package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
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

import demo.wrappers.Wrappers;

import java.time.Duration;

public class GoogleForms {

    private WebDriver driver;

    // Locators for the Google Form elements
    private By nameField = By.xpath("(//input[@class='whsOnd zHQkBf'])[1]");
    private By PracticeAutomation = By.xpath("//textarea[@class='KHxj8b tL9Q4c']");
    private By ExperieneceDropdown = By.id("i19"); // Update based on the actual option
    private By LearnJavaCheckbox = By.xpath("//div/span[text()='Java']");
    private By LearnSeleniumCheckbox = By.xpath("//div/span[text()='Selenium']");
    private By LearnTestngCheckbox = By.xpath("//div/span[text()='TestNG']");
    private By dropdownforaddressingBy = By.xpath("(//div[@role='presentation'])[1]");
    private By dropdownOption = By.xpath("//div[@data-value='Ms'  and @role='option']");
    private By dateElement = By.xpath("//input[@type='date']");
    private By TimeHourElement = By.xpath("//input[@aria-Label='Hour']");
    private By TimeMinsElement = By.xpath("//input[@aria-Label='Minute']");
    private By SucessMsg = By.xpath("//div[text()='Thanks for your response, Automation Wizard!']");

    private By submitButton = By.xpath("//div//span[text()='Submit']");
    private Wrappers wrapper;

    public GoogleForms(WebDriver driver) {
        this.driver = driver;
        this.wrapper = new Wrappers(driver);
    }
    // public Wrappers wrapper= new Wrappers(driver);

    // Methods to interact with the Google Form
    public void EnterDetails() throws InterruptedException {
        WebElement nameInput = driver.findElement(nameField);
        wrapper.sendKeys(nameInput, "Crio Learner");
        WebElement PracticeAutomations = driver.findElement(PracticeAutomation);
        String text = "I want to be the best QA Engineer! ";
        wrapper.sendKeysWithEpochTime(PracticeAutomations, text);
        WebElement Experience = driver.findElement(ExperieneceDropdown);
        wrapper.click(Experience);
        WebElement LearnedJava = driver.findElement(LearnJavaCheckbox);
        wrapper.checkbox(LearnedJava);

        WebElement LearnedSelenium = driver.findElement(LearnSeleniumCheckbox);
        wrapper.checkbox(LearnedSelenium);

        WebElement LearnedTestng = driver.findElement(LearnTestngCheckbox);
        wrapper.checkbox(LearnedTestng);
        WebElement HowToAddressBox = driver.findElement(dropdownforaddressingBy);
        wrapper.click(HowToAddressBox);
        WebElement HowToAddress = driver.findElement(dropdownOption);
        wrapper.click(HowToAddress);
          

    }

    // public void enterEmail(String email) {
    // WebElement emailInput = driver.findElement(emailField);
    // wrapper.sendKeys(emailInput, email);
    // }

    // public void HowMuchExperience() {
    // WebElement option = driver.findElement(dropdownOption);
    // driverWrapper.click(option);
    // }
    public void FindDate() {
        LocalDate currentDate = LocalDate.now().minusDays(7);

        // Step 2: Format the date in "dd/MM/yyyy" format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        WebElement dateInputBox = driver.findElement(dateElement);
        // dateInputBox.sendKeys(formattedDate);
        wrapper.sendKeys(dateInputBox, formattedDate);
    }

    public void LocalTime(String HourText, String MinuteText) {
        WebElement TimeNowHours = driver.findElement(TimeHourElement);
        wrapper.sendKeys(TimeNowHours, HourText);
        WebElement TimeNowMinutes = driver.findElement(TimeMinsElement);
        wrapper.sendKeys(TimeNowMinutes, MinuteText);
    }

    public void clickSubmit() throws InterruptedException {
        WebElement submitBtn = driver.findElement(submitButton);
        wrapper.click(submitBtn);

    }
public void  successmsgDisplay(){
    WebElement SucessMsgElement = driver.findElement(SucessMsg);
wrapper.getText(SucessMsgElement);
}
}