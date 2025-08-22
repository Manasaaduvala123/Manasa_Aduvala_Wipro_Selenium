package StepDefination;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LanguageStep {
	WebDriver driver;
	PageClass pc=new PageClass(driver);

@Given("home page should be open in  browser")
public void home_page_should_be_open_in_browser() {
	driver=new ChromeDriver();
	driver.get("https://www.ebay.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

@When("click on country")
public void click_on_country() {
	pc=new PageClass(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,2000)");

	pc.lang_in();
    
}

@Then("successfully change language")
public void successfully_change_language() {
    driver.close();
}




}
