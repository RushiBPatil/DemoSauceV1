package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);				
	}
	
	@FindBy(id="user-name") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button") WebElement loginbutton;
	@FindBy(xpath="//h3[@data-test='error']") WebElement errorMsg;
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void setPass(String Pass)
	{
		password.sendKeys(Pass);
	}
	
	public void clickToLogin()
	{
		ldriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		loginbutton.click();
	}
	public String checkError()
	{
		return errorMsg.getText();
	}
}
