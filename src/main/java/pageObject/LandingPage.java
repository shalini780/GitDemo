	package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By Title=By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By NavBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public loginPage getLogin()
	{
		 driver.findElement(signin).click();
		loginPage lp=new loginPage(driver);
		return lp;

	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	public int getPopupSize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement  getPopup()
	{
		return driver.findElement(popup);
	}
}

