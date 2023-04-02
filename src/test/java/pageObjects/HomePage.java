package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//finding elements in homepage for my account
	
	
	@FindBy(xpath="//span[text()='My Account']")
     WebElement	myacc;
	
	@FindBy(linkText = "Register")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")  //added in step 6
	WebElement lnklogin;
	
	//actions
	
	public void clickmyaccount()
	{
		myacc.click();
	}
	
	public void clickregister()
	{
		register.click();
	}
	
	public void clicklogin()
	{
		lnklogin.click();
	}
	
	
	

}
