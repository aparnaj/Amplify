package Global;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class Header {

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
	public void testHeader() {
		selenium.open("/recruit2/");
		//Verify Logo
		assertEquals(selenium.getText("css=a.brand > img"), "");
		//Clicking and checking Home link
		selenium.click("link=HOME");
		assertTrue(selenium.isTextPresent("The best way to hire programmers"));
		//Clicking and checking Pricing link
		selenium.click("link=PRICING");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("All plans come with a 30 day FREE trial"));
		//Clicking and checking Blog link
		selenium.click("link=BLOG");
		//Clicking and checking Contact us link
		selenium.click("link=CONTACT");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Contact us"));
		//Verifying login and Sign up buttons
		selenium.click("id=login_button");
		selenium.click("link=SIGN UP");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Get started with your 30 day FREE trial"));
	}

}
