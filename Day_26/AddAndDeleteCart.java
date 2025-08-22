package StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddAndDeleteCart {
	WebDriver driver;
	PageClass pc=new PageClass(driver);
	

@Given("product page should be open in default browsers")
public void product_page_should_be_open_in_default_browsers() {
    driver=new ChromeDriver();
    driver.get("https://www.ebay.com/itm/357452864391?_skw=watch...");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@When("click on the add to cart buttton")
public void click_on_the_add_to_cart_buttton() throws InterruptedException {
   pc=new PageClass(driver);
   pc.addtocart_in();
}

@And("click on see on cart button")
public void click_on_see_on_cart_button() {
   pc=new PageClass(driver);
   pc.seecart_in();
}

@And("click on remove from cart button")
public void click_on_remove_from_cart_button() throws InterruptedException {
    pc=new PageClass(driver);
    pc.removecart_in();
    Thread.sleep(2000);
}

@Then("item is add and remove successfully")
public void item_is_add_and_remove_successfully() {
    driver.close();
}

}


