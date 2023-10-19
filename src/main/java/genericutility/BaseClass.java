package genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeMethod
	public void configBeforeMethod() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.bt.com/");
		}
	
	@AfterMethod
	public void browserQuitAfterTestExecution() {
		driver.quit();
	}

}
