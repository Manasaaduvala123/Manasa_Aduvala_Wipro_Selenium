package TestNG_package;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class EcommerceAllTestCases {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void goToHome() {
        driver.get("http://automationpractice.com/");
    }

    @Test(priority = 1)
    public void loginTest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("login"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")))
                .sendKeys("testuser@example.com"); // replace with real credentials
            driver.findElement(By.id("passwd")).sendKeys("password123"); // replace with real password
            driver.findElement(By.id("SubmitLogin")).click();
            String heading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))
            ).getText();
            Assert.assertEquals(heading, "MY ACCOUNT", "Login failed!");
            System.out.println("Login successful.");
        } catch (Exception e) {
            System.out.println("Login test failed: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void productSearchAndAddToCart() {
        try {
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
            searchBox.sendKeys("dress");
            driver.findElement(By.name("submit_search")).click();
            WebElement firstProduct = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector(".product_list .product-container:first-of-type a.product-name")));
            firstProduct.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.name("Submit"))).click();
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".layer_cart_product h2")));
            Assert.assertTrue(successMsg.isDisplayed(), "Product not added to cart!");
            System.out.println("Product added to cart successfully.");
        } catch (Exception e) {
            System.out.println("Product add to cart failed: " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void checkoutFlow() {
        try {
            driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Proceed to checkout']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium")))
                .click();
            wait.until(ExpectedConditions.elementToBeClickable(By.name("processAddress"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("cgv"))).click();
            driver.findElement(By.name("processCarrier")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.className("bankwire"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart_navigation button"))).click();
            WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".cheque-indent strong")));
            Assert.assertTrue(confirmation.getText().contains("complete"), "Order not confirmed!");
            System.out.println("Order placed successfully.");
        } catch (Exception e) {
            System.out.println("Checkout flow failed: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void logoutTest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("logout"))).click();
            WebElement signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin")));
            Assert.assertTrue(signInBtn.isDisplayed(), "Logout failed!");
            System.out.println("Logout successful.");
        } catch (Exception e)
        {
            System.out.println("Logout test failed: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("All test cases executed.");
    }
}

