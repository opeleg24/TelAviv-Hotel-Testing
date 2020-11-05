package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TelAvivCityPage {
	public WebDriver driver;

	private By TelAvivCityPageTopLink = By.xpath("//div[@class='sq-menu sq-clearfix']/ul[1]/li[2]/a");
	private By TelAvivCityPageMiddleLink = By.cssSelector("div[class*='q-featured-post2'] a");
	private By TelAvivCityPageBottomLink = By.xpath("//div[@class='sq-footer sq-footer4']/aside/ul[1]/li[2]/a[1]");
	private By pageTelAvivCityText = By.cssSelector("div[class='sq-container'] h1");
	
	
	

	public TelAvivCityPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement clickTopLink() {
		return driver.findElement(TelAvivCityPageTopLink);
	}
	
	public WebElement clickMiddleLink() {
		return driver.findElement(TelAvivCityPageMiddleLink);
	}
	
	public WebElement clickBottomLink() {
		return driver.findElement(TelAvivCityPageTopLink);
	}
	
	
	public WebElement getPageTelAvivCityText() {
		return driver.findElement(pageTelAvivCityText);
	}


}
