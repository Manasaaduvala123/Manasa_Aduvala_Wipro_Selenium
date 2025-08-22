package StepDefination;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class SearchStep {
    WebDriver driver;

    @Given("eBay homepage is open in browser")
    public void ebay_homepage_is_open_in_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.ebay.com/");
    }

    @When("^user searches for (.*)$")
    public void user_searches_for_product(String product) {
        driver.findElement(By.id("gh-ac")).clear();
        driver.findElement(By.id("gh-ac")).sendKeys(product + Keys.ENTER );
    }

    @Then("^search results should be displayed for (.*)$")
    public void search_results_should_be_displayed_for_product(String product) {
        String pageTitle = driver.getTitle().toLowerCase();
        if (pageTitle.contains(product.toLowerCase())) {
            System.out.println("Search results displayed for: " + product);
        } else {
            throw new AssertionError("Search results not displayed for: " + product);
        }
        driver.quit();
    }
}
