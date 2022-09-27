package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	
	public WebDriver ldriver;
	public OverviewPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);				
	}
	
	@FindBy(xpath="//div[@class='inventory_item_name']") WebElement overviewProductName;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']") WebElement finalBtn;
	
	public String getOverviewProductName()
	{
		return overviewProductName.getText();
	}
	
	public void clickFinalBtn()
	{
		finalBtn.click();
	}
}
