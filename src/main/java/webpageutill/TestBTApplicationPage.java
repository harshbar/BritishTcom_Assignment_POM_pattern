package webpageutill;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestBTApplicationPage {
	private WebDriver driver;
	public TestBTApplicationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[text()='Accept all cookies']") WebElement acceptAppCookies;
	
	public void clickOnAcceptAllCookies() {
		acceptAppCookies.click();
	}
	
	@FindBy(xpath = "//span[text()='Mobile']") WebElement mobile;
	public void mouseHoverToMobile() {
		Actions act = new Actions(driver);
		act.moveToElement(mobile).perform();
		
	}
	
    @FindBy(xpath = "//a[text()='Mobile phones']") WebElement mobile_phone;
    public void clickOnMobilePhone() {
    	mobile_phone.click();
    }

	@FindBy(xpath = "//a[text()='See handset deals']/following-sibling::div/div") List<WebElement> bannerList;
	public int getBannerListCount() {
		return bannerList.size();
	}
	
	@FindBy(xpath="//a[text()='View SIM only deals']") WebElement viewSim;
	public void clickOnViewSIMonlyDeals() {
		viewSim.click();
	}
	
	//driver.findElement(By.xpath("//button[text()='125GB']")).click();
	@FindBy(xpath ="//button[text()='125GB']") WebElement GB125;
	public void clickOn125GB() {
		GB125.click();
	}
	
	@FindBy(xpath = "//div[@class='flex flex-wrap']/div/div/following-sibling::div/div[1]") List<WebElement> deals;
	public List<WebElement> getDealsListCount() {
		return deals;
	}
	
}
