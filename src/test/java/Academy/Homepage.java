package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Forgotpassword;
import pageObject.LandingPage;
import pageObject.loginPage;
import resources.base;

public class Homepage extends base {
	public WebDriver driver;
	public static Logger Log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		//call driver from main method using inheritance concept just say extends which class pro u use like base
		
			driver=initializeDriver();
			//driver.get("http://qaclickacademy.com");
			
			//there are 2 ways u access method of other class : inheritance , create object to that class and invoke methods of it
	}
	
	@Test(dataProvider="getData")
	
	public void basepageNavigation(String Username,String Password) throws IOException
	{
		//call driver from main method using inheritance concept just say extends which class pro u use like base
	
		//driver=initializeDriver();
	//	driver.get("http://qaclickacademy.com");
		//there are 2 ways u access method of other class : inheritance , create object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		loginPage lp = l.getLogin();//it is similar to driver.findelement
		//loginPage lp=new loginPage(driver);
		lp.getEmai().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getSubmit().click();
		Forgotpassword fp=lp.Forgotpass();
		fp.getEmai().sendKeys("xxxx");
		fp.sendMeInstruction().click();
		Log.info("homepage is successfully working");
	}	
	


	@AfterTest
	public void teardown()
	{
		driver.close();
	}	
	
		@DataProvider
		public Object[][] getData()
		{
			//Rows stands for how many differnt data types	test should run : 1TC >Restricted user ,2TC non Restricted user
			//column stands for how many values  per each test(like email value,passvalue.2
			//array starts with 0 index
			
			//Array size is 2
			//0,1 we arw checking in 2 indexes and size is 2 (0,1)
			
			Object [][] data= new Object[2][2];
			//0th row
			data[0][0]="restiectedyser@test.com";
			data[0][1]="123456";
			//1st row
			data[1][0]="nonrestiecteduser@test.com";
			data[1][1]="1234";
			
			return data;		
			
			
		}
		
	

}
