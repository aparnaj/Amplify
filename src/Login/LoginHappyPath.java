package Login;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LoginHappyPath {

	WebDriver driver;
	Selenium selenium;

	@BeforeMethod
	public void startSelenium() {
		driver = new FirefoxDriver();
		selenium = new WebDriverBackedSelenium(driver, "https://www.interviewstreet.com/recruit2/");
	}

	@AfterMethod
	public void stopSelenium() {
		driver.close();
	}

	@Test
	public void TestLoginHappyPath() {
		selenium.open("/recruit2/");
		//Log in using valid credentials
		selenium.click("id=login_button");
		selenium.type("id=email", "aparnachowdhary2004@gmail.com");
		selenium.type("id=password", "peace!43");
		selenium.click("id=login_action");
		//Verifying user is logged in 
		assertTrue(selenium.isTextPresent("CREATE TEST"));
		selenium.click("css=div.fade.in");
		assertTrue(selenium.isTextPresent("Aparna"));
		selenium.click("link=Aparna");
		//Verifying log out
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=login_button");
	}

}
