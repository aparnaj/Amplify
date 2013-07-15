package Global;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class Footer {

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
	public void TestFooter() {
		selenium.open("/recruit2/#");
		//Checking Footer logo
		assertEquals(selenium.getText("css=img.footer_logo"), "");
		//Checking Mobile Analytics logo
		assertEquals(selenium.getText("css=img[alt=\"Mobile Analytics\"]"), "");
		//Clicking and checking About us link
		selenium.click("xpath=/html/body/div[6]/ul/li[2]/a");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("About us"));
		selenium.goBack();
		selenium.waitForPageToLoad("30000");
		//Clicking and checking Contact Us link
		selenium.click("xpath=/html/body/div[6]/ul/li[4]/a");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getText("css=h4"), "Contact us");
		selenium.goBack();
		selenium.waitForPageToLoad("30000");
		//Clicking and checking Privacy Policy link
		selenium.click("xpath=/html/body/div[6]/ul/li[5]/a");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getText("css=h4"), "Privacy Policy");
		selenium.goBack();
		selenium.waitForPageToLoad("30000");
		//Clicking and checking Media Buzz link
		selenium.click("xpath=/html/body/div[6]/ul/li[6]/a");
		selenium.waitForPageToLoad("30000");
		assertEquals(selenium.getText("css=h4"), "Media Buzz");
	}

}
