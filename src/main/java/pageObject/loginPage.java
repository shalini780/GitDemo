	package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	
	By email =By.id("user_email");
	By pass=By.cssSelector("[type='password']");
	By submit=By.cssSelector("[type='submit']");
	By ForgotPassword = By.cssSelector("[href*='password/new']");
	
	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmai()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(pass);
	}
	
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	
	public Forgotpassword Forgotpass()
	{
		driver.findElement(ForgotPassword).click();
		Forgotpassword fp = new Forgotpassword(driver);
		return fp;
	}
}
