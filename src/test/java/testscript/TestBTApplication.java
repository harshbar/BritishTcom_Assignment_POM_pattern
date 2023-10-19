package testscript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import webpageutill.TestBTApplicationPage;

public class TestBTApplication extends BaseClass {

	@Test
	public void testBT() throws InterruptedException {
		
		TestBTApplicationPage BTpage = new TestBTApplicationPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.switchTo().frame("trustarc_cm");
		
		//driver.findElement(By.xpath("//a[text()='Accept all cookies']")).click();
		//Clicking on the Accept All Cookies.
		BTpage.clickOnAcceptAllCookies();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		
//		WebElement mobile = driver.findElement(By.xpath("//span[text()='Mobile']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(mobile).perform();
		//Mouse hover on the Mobile tab
		BTpage.mouseHoverToMobile();
		
		//driver.findElement(By.xpath("//a[text()='Mobile phones']")).click();
		// Clicking on the Mobile phone 
		BTpage.clickOnMobilePhone();
		
	//	List<WebElement> bannersList = driver.findElements(By.xpath("//a[text()='See handset deals']/following-sibling::div/div"));
		Assert.assertTrue(BTpage.getBannerListCount() >= 3 , "banner count is less than 3");
		
		//driver.findElement(By.xpath("//a[text()='View SIM only deals']")).click();
		BTpage.clickOnViewSIMonlyDeals();
		wait.until(ExpectedConditions.titleContains("SIM Only Deals"));
		Assert.assertTrue(driver.getTitle().contains("SIM Only Deals"), "Title validation for sim only is failed");
		
		//driver.findElement(By.xpath("//button[text()='125GB']")).click();
		BTpage.clickOn125GB();
		
		List<WebElement> deals = BTpage.getDealsListCount();
		boolean flag = true;
		int index = 1;
		for(WebElement ele : deals) {
			if(ele.getText().contains("£18.90")) {
				String captionValue = driver.findElement(By.xpath("(//div[@class='flex flex-wrap']/div/div[1])["+index+"]")).getText();
				Assert.assertEquals(captionValue, "30% off and double data");
				System.out.println(ele.getText());
				flag = false;
				break;
			}
			index++;
		}
		
		if(flag) {
			System.out.println("Required Plan is not exist");
		}
		
	}
}
