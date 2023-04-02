package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass
{
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginddt(String email, String password, String exp)
	{
		logger.info("*** Started TC_003_LoginDataDrivenTest***");
		try
		{
		
        HomePage hp=new HomePage(driver);
		
		hp.clickmyaccount();
		
		hp.clicklogin();
		
		
		LoginPage lp=new LoginPage(driver);
		 
		
		lp.setloginname(email); 
		
		lp.setloginpwd(password);
		
		lp.clicklogin();
		
		
		MyAccountPage myaccp=new MyAccountPage(driver);
		
		boolean targetheading=myaccp.isMyAccPageExits();
		
		
		if (exp.equals("Valid")) {
			if (targetheading == true) {
				myaccp.clicklogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equals("Invalid")) {
			if (targetheading == true) {
				MyAccountPage myaccpage = new MyAccountPage(driver);
				myaccpage.clicklogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	} catch (Exception e) {
		Assert.fail();
	}

	logger.info(" Finished TC_003_LoginDataDrivenTest");

}

}

	
		

