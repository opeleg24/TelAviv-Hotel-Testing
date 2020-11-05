package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	public WebDriver driver;

	private By ContactUsPageTopLink = By.xpath("//div[@class='sq-menu sq-clearfix']/ul[1]/li[4]/a");
	private By ContactUsPageBottomLink = By.xpath("//div[@class='sq-footer sq-footer4']/aside/ul[1]/li[4]/a[1]");
	private By pageContactUsText = By.cssSelector("div[class='sq-container'] h1");
	private By name =By.cssSelector("[name='your-name']");
	private By email =By.cssSelector("[name='your-email']");
	private By subject =By.cssSelector("[name='your-subject']");
	private By message =By.cssSelector("[name='your-message']");
	private By sumbit =By.cssSelector("[type='submit']");
	private By successMessage =By.cssSelector("[class*='wpcf7-mail-sent-ok']");
	private By fieldRequiredMessage =By.cssSelector("[class='wpcf7-not-valid-tip']");
	
	

	
	

	public ContactUsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement clickTopLink() {
		return driver.findElement(ContactUsPageTopLink);
	}
	
	public WebElement clickBottomLink() {
		return driver.findElement(ContactUsPageTopLink);
	}
	
	
	public WebElement getPageContactUsText() {
		return driver.findElement(pageContactUsText);
	}
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getSubject() {
		return driver.findElement(subject);
	}
	
	public WebElement getMessage() {
		return driver.findElement(message);
	}
	
	public WebElement getSumbit() {
		return driver.findElement(sumbit);
	}
	
	public WebElement getSuccessMessage() {
		return driver.findElement(successMessage);
	}
	
	public WebElement getFieldRequiredMessage() {
		return driver.findElement(fieldRequiredMessage);
	}
	
	public void waitForContactUsTextSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	}
	
	public void waitForContactUsTextFieldRequiredMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fieldRequiredMessage));
	}

	
	
	
	
	
	


}
