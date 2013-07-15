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
		assertEquals(selenium.getText("css=a.brand > img"), "");
		selenium.click("link=HOME");
		assertTrue(selenium.isTextPresent("The best way to hire programmers"));
		selenium.click("link=PRICING");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("All plans come with a 30 day FREE trial"));
		selenium.click("link=BLOG");
		selenium.click("link=CONTACT");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Contact us"));
		selenium.click("id=login_button");
		selenium.click("link=SIGN UP");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Get started with your 30 day FREE trial"));
	}

}
