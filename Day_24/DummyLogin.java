//3Q. Write test cases for a dummy login page using @Parameters in testng.xml.

package miniProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DummyLogin {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/signin/");
    }
    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        emailBox.clear();
        emailBox.sendKeys(username);

        driver.findElement(By.id("signin-continue-btn")).click();
        try {
        WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        passwordBox.clear();
        passwordBox.sendKeys(password);

        driver.findElement(By.id("sgnBt")).click();

        System.out.println("Login attempted with username: " + username);
        }
        catch(Exception e)
        {
        	System.out.println("invalid username or login flow changed");
        }
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
