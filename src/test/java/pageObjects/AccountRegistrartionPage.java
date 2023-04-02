package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrartionPage extends BasePage
{
	
	public AccountRegistrartionPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//elements in registration page
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(name = "telephone")
	WebElement txt_tel;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(name = "confirm")
	WebElement txt_ConfirmPassword;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_privacypolicy;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement btn_newsletter;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;

	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement acc_confirmation;
	
	
	//actions on above elements
	
	
	public void setfirstname(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	public void setemail(String email)
	{
		txt_email.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txt_tel.sendKeys(tel);

	}
	
	public void setpassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void setConfirmPassword(String pwd) {
		txt_ConfirmPassword.sendKeys(pwd);
	}
	
	public void clickpolicyr()
	{
		chk_privacypolicy.click();
	}
	
	public void clicknewsletter()
	{
		btn_newsletter.click();
	}
	
	public void clickcontinue()
	{
		btn_continue.click();
	}
	
	public String getconfirmationmsg()
	{
		try
		{
			return(acc_confirmation.getText());
		}
		catch(Exception e)
		{
		  return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
