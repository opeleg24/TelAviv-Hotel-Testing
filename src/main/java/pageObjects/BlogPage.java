package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPage {
	public WebDriver driver;

	private By blogPageTopLink = By.xpath("//div[@class='sq-menu sq-clearfix']/ul[1]/li[3]/a");
	private By blogPageMiddleLink = By.cssSelector("div[class*='q-featured-post3'] a");
	private By blogPageBottomLink = By.xpath("//div[@class='sq-footer sq-footer4']/aside/ul[1]/li[3]/a[1]");
	private By pageBlogPageText = By.cssSelector("div[class='sq-container'] h1");
	private By blogPageLinks = By.xpath("//div[@class='sq-footer sq-footer3']/aside/ul/li/a");
	private By blogReplyComment = By.id("comment");
	private By blogReplyAuthor = By.id("author");
	private By blogReplyEmail = By.id("email");
	private By blogReplyUrl = By.id("url");
	private By blogReplySubmit = By.id("submit");
	private By blogReplyClickSaveInfoBox = By.id("wp-comment-cookies-consent");
	private By blogReplySuccessMessage = By.cssSelector(".comment-awaiting-moderation");
	private By blogReplyError = By.xpath("//body[@id='error-page']/p[2]");
	private By blogReplyErrorBackButton = By.xpath("//body[@id='error-page']/p[4]/a");

	
	


	public BlogPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement clickTopLink() {
		return driver.findElement(blogPageTopLink);
	}
	
	public WebElement clickMiddleLink() {
		return driver.findElement(blogPageMiddleLink);
	}
	
	public WebElement clickBottomLink() {
		return driver.findElement(blogPageBottomLink);
	}
	
	
	public WebElement getBlogPageText() {
		return driver.findElement(pageBlogPageText);
	}
	
	public void waitForBlogLink() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(blogPageBottomLink));
	}
	
	public void waitForBlogText() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pageBlogPageText));
	}
	
	public List<WebElement> getBlogLinks()
	{
		return driver.findElements(blogPageLinks);
	}
	
	public List<String> blogPageTitleText() {

		List<String> BlogPageTitleText = Arrays.asList(
				"ROAD TRIP : MY LAST WEEKEND MEMORIES",
				"MEMORIES FROM THE LAST SUMMER",
				"FLOWERS & DECORATIONS",
				"ADVENTURE & OPTIMISM",
				"MY TRIP TO NEW YORK"
				);
		return BlogPageTitleText;

	}
	public WebElement getComment() {
		return driver.findElement(blogReplyComment);
	}
	public WebElement getAuthor() {
		return driver.findElement(blogReplyAuthor);
	}
	public WebElement getUrl() {
		return driver.findElement(blogReplyUrl);
	}
	public WebElement getEmail() {
		return driver.findElement(blogReplyEmail);
	}
	public WebElement getInfoBox() {
		return driver.findElement(blogReplyClickSaveInfoBox);
	}
	public WebElement sumbit() {
		return driver.findElement(blogReplySubmit);
	}
	
	public WebElement getSuccessMessage() {
		return driver.findElement(blogReplySuccessMessage);
	}
	
	public WebElement getErrorMessage() {
		return driver.findElement(blogReplyError);
	}
	public WebElement getErrorMessageBackButton() {
		return driver.findElement(blogReplyErrorBackButton);
	}


	public void waitReplySuccessMsg() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(blogReplySuccessMessage));
	}


}
