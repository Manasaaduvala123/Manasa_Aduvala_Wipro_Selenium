package StepDefination;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginStep {
    WebDriver driver;

    @Given("login page should be open in default browser")
    public void login_page_should_be_open_in_default_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&sgfl=gh&ru=https%3A%2F%2Fwww.ebay.com%2F");
    }

    @When("^click on login button and enter (.*)$")
    public void click_on_login_button_and_enter_email(String username) {
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys(username);
    }

    @And("click on continue button")
    public void click_on_continue_button() {
        driver.findElement(By.id("signin-continue-btn")).click();
    }

    @When("^add (.*)$")
    public void add_password1(String password) {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    @And("^click on signin button check (.*)$")
    public void click_on_signin_button_check_status(String status) {
        driver.findElement(By.id("sgnBt")).click();

        if (status.equalsIgnoreCase("valid")) {
            boolean homeDisplayed = driver.getCurrentUrl().contains("ebay.com");
            if (homeDisplayed) {
                System.out.println("Login successful with valid credentials.");
            } else {
                throw new AssertionError("Expected successful login, but failed.");
            }
        } else if (status.equalsIgnoreCase("invalid")) {
            boolean errorDisplayed = driver.findElements(By.id("errf")).size() > 0 
                                   || driver.getPageSource().contains("incorrect");
            if (errorDisplayed) {
                System.out.println("Correctly displayed error for invalid login.");
            } else {
                throw new AssertionError("Expected login error, but login succeeded.");
            }
        }
    }

    @Then("login successfully and open home page")
    public void login_successfully_and_open_home_page() {
        driver.quit();
    }
}
