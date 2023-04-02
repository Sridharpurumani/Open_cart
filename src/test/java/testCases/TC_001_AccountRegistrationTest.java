package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pageObjects.AccountRegistrartionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	

	@Test(groups= {"Regression","Master"})
	public void testaccountregistartion() throws InterruptedException
	{
		
		
		
		//logger.debug("application logs....");
		
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try
		{
		
		HomePage hp=new HomePage(driver);
		
		
		hp.clickmyaccount();
		
		logger.info("Clicked on Myaccount");
		
		hp.clickregister();
		
		logger.info("Clicked on Register");
		
		
		
		AccountRegistrartionPage arp=new AccountRegistrartionPage(driver);
		
		logger.info("Providing Customer Data");
		
		arp.setfirstname(randomstring().toUpperCase()); //if we want to change to upper or lower we can use .to after bracket
		
		arp.setlastname(randomstring().toUpperCase());
		
		arp.setemail(randomstring()+"@gmail.com");
		
		arp.setTelephone(randomNumber());
		
		String password=randomalphanumeric();
		
		arp.setpassword(password);  //if we have confirm password option as well--->// String password=randomalphanumeric();
		                                        //arp.setpassword(password);
		arp.setConfirmPassword(password);                                      //arp.setconfirmpassword(password); 
		
		arp.clickpolicyr();
		
		arp.clicknewsletter();
		
		arp.clickcontinue();
		
		logger.info("Clicked on Continue");
		
		
		
		String verificationmsg=arp.getconfirmationmsg();
		
		logger.info("Validating Expected Msg");
		
		
		Assert.assertEquals(verificationmsg, "Your Account Has Been Created!", "Not getting expected msg");
	}
	catch(Exception e )
	{
		
		logger.info("Test Failed.....");
	Assert.fail();
	}
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
	}
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	