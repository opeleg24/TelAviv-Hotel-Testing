package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage {
	public WebDriver driver;

	private By aboutUsPageTopLink = By.xpath("//div[@class='sq-menu sq-clearfix']/ul[1]/li[1]/a");
	private By aboutUsPageMiddleLink = By.cssSelector("div[class*='q-featured-post1'] a");
	private By aboutUsPageBottomLink = By.xpath("//div[@class='sq-footer sq-footer4']/aside/ul[1]/li[1]/a[1]");
	private By pageAboutUsText = By.cssSelector("div[class='sq-container'] h1");
	
	
	

	public AboutUsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement clickTopLink() {
		return driver.findElement(aboutUsPageTopLink);
	}
	
	public WebElement clickMiddleLink() {
		return driver.findElement(aboutUsPageMiddleLink);
	}
	
	public WebElement clickBottomLink() {
		return driver.findElement(aboutUsPageTopLink);
	}
	
	
	public WebElement getPageAboutUsText() {
		return driver.findElement(pageAboutUsText);
	}
	
	public void waitForAboutUsLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(aboutUsPageBottomLink));
	}
	
	public void waitForAboutUsText() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageAboutUsText));
	}


}
