// 1Q. Create 2 test cases, disable one using enabled = false, and run only the active test.

package miniProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TwoTestCases {
	 WebDriver driver;
	 WebDriverWait wait;
	    @BeforeTest
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.ebay.com/");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	    @Test(enabled = true, priority = 1)
	    public void searchProduct() throws InterruptedException {
	        WebElement searchBox = driver.findElement(By.id("gh-ac"));
	        searchBox.sendKeys("laptop");
	        searchBox.sendKeys(Keys.ENTER);
	        driver.findElement(By.id("gh-btn")).click();
	        Thread.sleep(3000);
	        System.out.println("Search test executed successfully!");
	    }
	    @Test(enabled = false, priority = 2)
	    public void searchMobilePhone() throws InterruptedException {
	        WebElement searchBox = driver.findElement(By.id("gh-ac"));
	        searchBox.clear();
	        searchBox.sendKeys("mobile phone");
	        searchBox.sendKeys(Keys.ENTER);
	        driver.findElement(By.id("gh-btn")).click();
	        Thread.sleep(2000);
	        System.out.println("Mobile phone search test executed successfully!");
	    }

	    @AfterTest
	    public void tearDown() throws InterruptedException {
	    	Thread.sleep(4000);
	        driver.close();
	    }
	}
