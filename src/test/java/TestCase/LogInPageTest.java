package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LogInPageTest extends TestBase {
	
	LoginPage log;
	
	@BeforeMethod
	public void set() throws IOException {
		init();
		log = new LoginPage();
	}
	
	
	@Test
	public void verifyTitleTest() {
		String title = log.verifyTitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", title);
	
	}
	
	@Test
	
	public void loginToAppTest() throws IOException {
		log.loginToApp();
		
	}
	
	
	@Test (enabled = false)
	public void verifyKiteLogoTest() {
		
		boolean value = log.verifyKiteLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test
	public void verifyZerodhaLogoTest() {
		boolean value = log.verifyZerodhaLogo();
		Assert.assertEquals(value, true);
	}
	
	
	@AfterMethod
	
	public void exit() {
		driver.close();
	}

}
