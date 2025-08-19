// 2Q. Write a test to run the same test multiple times.

package miniProject;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class RepeatTestCaseRun {
	 WebDriver driver;
	    WebDriverWait wait;
	    @BeforeTest
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.ebay.com/");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    @Test(invocationCount = 3)
	    public void searchLaptop() {
	        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
	        searchBox.clear();
	        searchBox.sendKeys("laptop");
	        searchBox.sendKeys(Keys.ENTER);
	        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-btn")));
	        searchBtn.click();
	        wait.until(ExpectedConditions.titleContains("laptop"));
	        Assert.assertTrue(driver.getTitle().toLowerCase().contains("laptop"),
	                "Search results did not load correctly!");
	        System.out.println("Laptop search test executed successfully!");
	    }
	    @AfterTest
	    public void tearDown() throws InterruptedException {
	        Thread.sleep(3000); 
	        driver.quit();
	    }
	}

