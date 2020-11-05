package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpChat {

	public WebDriver driver;

	private By helpChatButton = By.cssSelector("button[id='button-body']");
	private By helpChatInputMsgEmail = By.cssSelector("input[placeholder='Enter your email...']");
	private By helpChatInputMsgEmailSend = By.cssSelector("button[class='user-data-modal-submit']");
	private By helpChatInputMsg = By.id("new-message-textarea");
	private By helpChatInputMsgTest = By.cssSelector("span[class='message-content']");

	public HelpChat(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getHelpChatButton() {
		return driver.findElement(helpChatButton);
	}

	public WebElement getHelpChatEmail() {
		return driver.findElement(helpChatInputMsgEmail);
	}
	
	public WebElement getHelpChatEmailSend() {
		return driver.findElement(helpChatInputMsgEmailSend);
	}

	public WebElement sendHelpChatInputMsg() {
		return driver.findElement(helpChatInputMsg);
	}

	public WebElement getHelpChatInputMsgTest() {
		return driver.findElement(helpChatInputMsgTest);
	}

	public void waitForGetHelpChatButton() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(helpChatButton));
	}

}
