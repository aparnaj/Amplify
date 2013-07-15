
package Registration;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.ie.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class RegistrationHappyPath  {

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
	public void testHappyPath() {
		selenium.open("/recruit2/");
		//Registering a New User
		selenium.click("link=SIGN UP");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=inputEmail", "vancha.neelima@gmail.com");
		selenium.type("id=inputPassword", "peace!43");
		selenium.type("id=inputFirstName", "Neelima");
		selenium.type("id=inputCompany", "Personal");
		selenium.type("id=inputNumber", "1122334567");
		selenium.click("name=signup_button");
		//Verifying Home page after Registration
		assertTrue(selenium.isTextPresent("CREATE TEST"));
		assertEquals(selenium.getTable("css=table.0.1"), "Add Questions");
		assertEquals(selenium.getTable("css=table.0.2"), "Invite Candidates");
		assertEquals(selenium.getTable("css=table.0.3"), "View Reports");
		selenium.click("css=div.fade.in");
		assertTrue(selenium.isTextPresent("Neelima"));
		selenium.click("link=Neelima");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=login_button");
	}

}