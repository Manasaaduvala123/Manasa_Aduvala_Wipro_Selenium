package StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllCategory {
	WebDriver driver;
	PageClass pc;

	@Given("home page should be open in default browser")
	public void home_page_should_be_open_in_default_browser() {
		driver=new ChromeDriver();
	    driver.get("https://www.ebay.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    pc=new PageClass(driver);
	}

	@When("click on all-category")
	public void click_on_all_category() throws InterruptedException {
		pc.all_category();

	}

	@And("click on search button")
	public void click_on_search_button() throws InterruptedException {
	    pc.searchbtn_in();

	}

	@Then("all category successfull")
	public void all_category_successfull() {
		driver.quit();
	}
}
