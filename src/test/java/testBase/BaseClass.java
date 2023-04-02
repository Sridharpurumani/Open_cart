package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass
{

	public static WebDriver driver;
	
	public Logger logger; //for logging
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Regression","sanity","Master"})
	@Parameters("browser")
	public void setup(String br)
	{
	
	rb=ResourceBundle.getBundle("config"); //loading config.properties file
		
		logger=LogManager.getLogger(this.getClass());  //this represents current class
		
	if(br.equals("chrome"))
			{
		
		
		ChromeOptions co=new ChromeOptions();
		
		co.addArguments("--remote-allow-origins=*");
	   
		//co.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});  //to avoid msg chrome is controlled by automated ....while running
		
	    driver=new ChromeDriver(co);
	    
			}
	else if(br.equals("edge"))
	{
		driver =new EdgeDriver();
	}
	
	else
	{
		driver=new FirefoxDriver();
	}
		
	    driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(50));
		
		
		//driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		
		driver.get(rb.getString("URL"));        //getting value from config file
		
		
	}
	
	@AfterClass(groups= {"Regression","sanity","Master"})
	public void teardown()
	{
		driver.quit();
	
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		
		return(generatedstring);
	
	}
	
	public String randomNumber()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(10);
		
		return(generatedstring2);
	
	}
	
	public String randomalphanumeric()
	{
		
		String str=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(str+"@"+num);
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
	    File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
	    String destination = System.getProperty("user.dir") + "\\Users/sridharreddy/Desktop/eclipse data/opencar_project/screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
