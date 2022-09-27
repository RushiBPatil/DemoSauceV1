package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OverviewPage;
import pageObjects.ProductsPage;

public class Steps extends BaseClass {
	
	String selectedProduct,errorMsg;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + ".\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@When("User opens Sauce Website")
	public void user_opens_sauce_website() {
		driver.get(BaseClass.prop.getProperty("URL"));
	}

	@And("User enters Username and Password")
	public void user_enters_username_and_password() {
		loginpage = new LoginPage(driver);
		loginpage.setUsername(BaseClass.prop.getProperty("username"));
		loginpage.setPass(BaseClass.prop.getProperty("password"));
	}
	
	@And("Click on LOGIN")
	public void click_on_login() {		
		loginpage.clickToLogin();
	}
	
	@And("Add the product to the cart")
	public void add_the_product_to_the_cart() throws InterruptedException {
		productsPage=new ProductsPage(driver);
		selectedProduct= productsPage.getProductName();		
		productsPage.addProductToCart();
	}
	
	@Then("Click on cart link")
	public void click_on_cart_link() throws InterruptedException {
		productsPage.clickOnCartLink();
	}
	
	@And("Click on Checkout the product")
	public void click_on_checkout_the_product() {
		cartPage=new CartPage(driver);
		cartPage.clickCheckout();
	}
	
	@Then("Enter First name as {string} Last name as {string} and Zip code as {string} on Checkout page")
	public void enter_first_name_as_last_name_as_and_zip_code_as_on_checkout_page(String fname, String lname, String zip) {
		checkoutPage=new CheckoutPage(driver);
		checkoutPage.setFirstName(fname);
		checkoutPage.setLastName(lname);
		checkoutPage.setZipCode(zip);
		
	}
	
	@Then("Click on Checkout button")
	public void click_on_checkout_button() throws InterruptedException {
		checkoutPage.clickContinue();
	}

	@And("Validate the ordered product details")
	public void validate_the_ordered_product_details() {
	    overviewPage=new OverviewPage(driver);
		String finalProd=overviewPage.getOverviewProductName();
	    Assert.assertEquals(finalProd,selectedProduct);	
	    overviewPage.clickFinalBtn();
	}
	
	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String string, String string2) {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(string);
		loginpage.setPass(string2);
		loginpage.clickToLogin();
	}

	@Then("Validate error message")
	public void validate_error_message() {
		errorMsg=loginpage.checkError();
		Assert.assertNotNull(errorMsg);		
	}
	
	@Then("Check product {string} is available or not")
	public void check_product_is_available_or_not(String string) {
		productsPage=new ProductsPage(driver);
		Assert.assertTrue(string+" product is not available",productsPage.checkProductAvailable(string));
	}
	
	@Then("Validate price with product individual page")
	public void validate_price_with_product_individual_page() {
		productsPage=new ProductsPage(driver);
		Assert.assertTrue("Product Amount not matched",productsPage.checkPriceOfAllProduct());
	}
	
	@Then("Close browser")
	public void close_browser()
	{
		driver.close();
	}
}
