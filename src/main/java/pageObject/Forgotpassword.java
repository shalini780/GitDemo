	package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {

	public WebDriver driver;
	
	By email =By.id("user_email");
	By sendMeInstruction=By.cssSelector("[type='submit']");
	
	public Forgotpassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmai()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendMeInstruction()
	{
		return driver.findElement(sendMeInstruction);

	}
	
}
