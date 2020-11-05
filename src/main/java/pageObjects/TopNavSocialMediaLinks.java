package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavSocialMediaLinks {
	
	
public WebDriver driver;
	
	private By socialMediaLinks=By.xpath("//div[@class='sq-top-right-header']/a");
	private By sociaMediaDiv=By.cssSelector("div[class='sq-top-right-header']");

	
	public TopNavSocialMediaLinks(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public List<WebElement> getSocialMediaLinks()
	{
		return driver.findElements(socialMediaLinks);
	}
	
	
//	public void waitForVisibility() throws Error{
//        new WebDriverWait(driver, 5)
//             .until(ExpectedConditions.visibilityOf((WebElement) sociaMediaDiv));
// }
//
//	
//    public void waitForElement() {
// 	   
//    WebDriverWait wait = new WebDriverWait(driver, 5);
//    wait.until(ExpectedConditions.presenceOfElementLocated (By.className(".sq-top-right-header")));
//	
//}
//	

}
