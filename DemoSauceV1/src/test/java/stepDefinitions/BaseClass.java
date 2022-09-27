package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.OverviewPage;
import pageObjects.ProductsPage;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	LoginPage loginpage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	OverviewPage overviewPage;

	public static void readConfig() throws Exception {
		prop = new Properties();
		File src = new File(System.getProperty("user.dir") + ".\\configuration\\config.properties");
		FileInputStream fis = new FileInputStream(src);		
		prop.load(fis);
	}
}
