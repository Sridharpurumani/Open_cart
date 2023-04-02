package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//a[normalize-space()='Your Store']")
	WebElement myaccheading;
	@FindBy(xpath="//span[@class='caret']")
	WebElement lnkarrow;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement lnklogout;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement lnkcontinue;
	
	public boolean isMyAccPageExits()
	{
		try
		{
			return(myaccheading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
	public void clickcontinue()
	{
		lnkcontinue.click();
	}
	
	public void myaccount()
	{
		lnkarrow.click();
	}
	
}
