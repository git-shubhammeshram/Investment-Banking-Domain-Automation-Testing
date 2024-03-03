package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	
	public String readPrpertiesFile(String url) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream readFile = new FileInputStream("\\Users\\91942\\eclipse-workspace\\ZerodhaSite\\src\\main\\java\\Config\\config.properties");
		prop.load(readFile);
		return prop.getProperty(url);
	
	}
	
	public void init() throws IOException {
		
		String browser = readPrpertiesFile("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			
			
			System.setProperty("Webdriver.chrome.driver", "ChromeDriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver", "GeckoDriver");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		/*driver.get("https://kite.zerodha.com/");*/
		driver.get(readPrpertiesFile("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

}
