package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import sun.net.ftp.FtpDirEntry.Type;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException 
	{
		
		 prop = new Properties();
		 //C:\\Users\\Shalu didi\\eclipse-workspace\\E2Eproject
		// System.getProperty("user.dir") > use this to remove hard code path C:\\Users\\Shalu didi\\eclipse-workspace\\E2Eproject
		
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		//u need to give the path of datadriven file & for that u have create the .property file
		
		prop.load(fis);
		
		//mvn test -Dbrowser=Chrome
		String browserName=System.getProperty("browser");
		
		
		//String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			//C:\\Users\\Shalu didi\\chromedriver_win32
			//replace hard code path and move chromedriver.exe in resources folder
			//System.getProperty("user.dir")
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			// driver=new ChromeDriver();
			//for chromeheadless
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("chromeheadless"))
			{
			options.addArguments("headless"); // run test using without browser
			}
			 driver=new ChromeDriver(options); // run test using browser
			
		}
		else if(browserName.equals("FirefoxDriver"))	
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Shalu didi\\Documents\\geckodriver.exe");
			 driver=new FirefoxDriver();

		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Shalu didi\\Documents\\MicrosoftWebDriver.exe");
			
			 driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;//sending driver back to use
		
	}	
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
