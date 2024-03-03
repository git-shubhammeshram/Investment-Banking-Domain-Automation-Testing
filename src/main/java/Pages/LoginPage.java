package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath = "//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath = "//input[@id='userid']") private  WebElement userTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passTextBox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement logBtn;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyKiteLogo() {
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo() {
		return zerodhaLogo.isDisplayed();
	}
	
	public void loginToApp() throws IOException {
		userTextBox.sendKeys(readPrpertiesFile("userName"));
		passTextBox.sendKeys(readPrpertiesFile("userPass"));
		logBtn.click();
	}

}
