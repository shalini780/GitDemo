package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.loginPage;
import resources.base;

public class validateNavigationBar extends base {
	public WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void initialize() throws IOException
	{
		//call driver from main method using inheritance concept just say extends which class pro u use like base
		
			driver=initializeDriver();
			//driver.get("http://qaclickacademy.com");
			driver.get(prop.getProperty("url"));
			//there are 2 ways u access method of other class : inheritance , create object to that class and invoke methods of it
	}
	
	@Test
	
	public void basepageNavigation() throws IOException
	{
		//call driver from main method using inheritance concept just say extends which class pro u use like base
	
	//	driver=initializeDriver();
	//	driver.get(prop.getProperty("url"));
		//there are 2 ways u access method of other class : inheritance , create object to that class and invoke methods of it
		
		LandingPage l=new LandingPage(driver);
		//compare the text from browser with actual text -
		
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		Log.info("Navigation bar is displayed");
	}	
		
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	

}
