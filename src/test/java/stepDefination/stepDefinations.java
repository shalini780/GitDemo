package stepDefination;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.loginPage;
import pageObject.portalHomePage;
import resources.base;

public class stepDefinations extends base {
	
	
	@Given("^Initalize the browser with chrome$")
	public void initalize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();  
	}

	@Given("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^click on login link in home page to land in sign in page$")
	public void click_on_login_link_in_home_page_to_land_in_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		LandingPage l=new LandingPage(driver);
		loginPage lp = l.getLogin();
		if(l.getPopupSize()>0)
		{
			l.getPopup().click();
		}
	}

	/*@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l=new LandingPage(driver);
		loginPage lp = l.getLogin();
		lp.getEmai().sendKeys(arg1);
		lp.getPassword().sendKeys(arg2);
		lp.getSubmit().click();
	}*/

	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LandingPage l=new LandingPage(driver);
			loginPage lp = l.getLogin();
			lp.getEmai().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getSubmit().click();
	    }
	
	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		portalHomePage p =new portalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());	
	}
	
	 @And("^Close browser$")
	    public void close_browser() throws Throwable {
	        driver.quit();
	    }

}
