package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	public WebDriver ldriver;
	String productfromHomePage, pricefromHomePage, priceWithoutDollar1, productPrice, priceWithoutDollar2 = "";
	
	public ProductsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);				
	}
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") WebElement addToCart;
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']") WebElement productName;
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']//ancestor::div[@class='inventory_item_label']//following-sibling::div/div[@class='inventory_item_price']") WebElement price;
	@FindBy(xpath="//a[@class='shopping_cart_link']") WebElement cartLink;
	@FindAll(@FindBy(xpath="//div[@class='inventory_item_name']")) List<WebElement> allProductsName;
	@FindAll(@FindBy(xpath="//div[@class='inventory_item']")) List<WebElement> productList;
	@FindAll(@FindBy(xpath="//div[@class='inventory_item_price']")) List<WebElement> allProductsPrice;
	@FindBy(xpath="//div[@class='inventory_details_price']") WebElement productPopUpPrice;
	@FindBy(xpath="//button[@name='back-to-products']") WebElement backToCartBtn;
	
	
	public void addProductToCart()
	{		
		addToCart.click();
	}
	
	public String getProductName() {

		return productName.getText();		
	}

	public String getProductPrice() {
		String productPrice = price.getText();
		return productPrice;
	}		
	
	public void clickOnCartLink() throws InterruptedException
	{
		cartLink.click();
		Thread.sleep(3000);
		System.out.println("Done with clicking on cartlink");
	}
	
	public void getAllproducts()
	{
		for(WebElement item:allProductsName)
		{
			System.out.println(item.getText());
		}		
	}
	
	public boolean checkProductAvailable(String name)
	{
		for(WebElement item:allProductsName)
		{
			String prodName= item.getText();
			if(prodName.equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean checkPriceOfAllProduct()
	{
		for (int i = 0; i < productList.size(); i++) {
			productfromHomePage = ldriver.findElement(By.xpath("//div[@class='inventory_item'][" + (i + 1) + "]//div[@class='inventory_item_label']/a")).getText();
			pricefromHomePage = ldriver.findElement(By.xpath("//div[@class='inventory_item'][" + (i + 1) + "]//div[@class='inventory_item_price']")).getText();
			priceWithoutDollar1 = pricefromHomePage.replace("$", "");
			ldriver.findElement(By.xpath("//div[@class='inventory_item'][" + (i + 1) + "]//div[@class='inventory_item_label']/a")).click();
			productPrice = ldriver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
			priceWithoutDollar2 = productPrice.replace("$", "");
			
			if (priceWithoutDollar1.equals(priceWithoutDollar2)) {
				System.out.println(productfromHomePage+" product's price matched");
				ldriver.findElement(By.xpath("//button[@id='back-to-products']")).click();				
			}
			else {
				System.out.println(productfromHomePage+" product's price did not matched");
				return false;
			}			
		}
		return true;
	}
}
