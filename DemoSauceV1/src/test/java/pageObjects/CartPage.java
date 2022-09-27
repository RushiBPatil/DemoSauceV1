package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public WebDriver ldriver;
	public CartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		System.out.println("Title is "+rdriver.getTitle());
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="checkout") WebElement checkout;
	
	
	public void clickCheckout()
	{
		System.out.println("button name "+checkout.getText());
		checkout.click();
	}
}
