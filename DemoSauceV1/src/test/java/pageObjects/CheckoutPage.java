package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public WebDriver ldriver;
	public CheckoutPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);				
	}
	
	@FindBy(id="first-name") WebElement firstName;
	@FindBy(id="last-name") WebElement lastName;
	@FindBy(id="postal-code") WebElement zipCode;
	@FindBy(id="continue") WebElement continueBtn;
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);		
	}
	
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);		
	}
	
	public void setZipCode(String zip)
	{
		zipCode.sendKeys(zip);		
	}
	
	public void clickContinue() throws InterruptedException
	{
		Thread.sleep(2000);
		continueBtn.click();		
	}
}
