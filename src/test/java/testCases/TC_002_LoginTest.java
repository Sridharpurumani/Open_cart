package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"sanity","Master"})
	public void logintest()
	{
		
		try
		{
		logger.info("*** TC_002_LoginTestn Started ***");
		
		
		HomePage hp=new HomePage(driver);
		
		hp.clickmyaccount();
		
		hp.clicklogin();
		
		
		LoginPage lp=new LoginPage(driver);
		 
		logger.info("*** Entering Username and Password ***");
		lp.setloginname(rb.getString("Username"));  //getting username from config.file
		
		lp.setloginpwd("Password");
		
		lp.clicklogin();
		
		logger.info("*** Login done and Checking Your Store heading ***");
		
		MyAccountPage myaccp=new MyAccountPage(driver);
		
		boolean targetheading=myaccp.isMyAccPageExits();
		
		Assert.assertEquals(targetheading, true);
		
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** TC_002_LoginTest Finished ***");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}