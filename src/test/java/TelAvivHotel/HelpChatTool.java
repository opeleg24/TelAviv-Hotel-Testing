package TelAvivHotel;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HelpChat;
import resources.base;

public class HelpChatTool extends base {

	public WebDriver driver;
	public HelpChat helpChat;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		helpChat = new HelpChat(driver);

	}

	@Test

	public void validateChatMsgTool() throws IOException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("tidio-chat-iframe");
		helpChat.waitForGetHelpChatButton();
		log.debug("Clicking Help Chat Button");
		helpChat.getHelpChatButton().click();
		log.debug("Inputing test message");
		helpChat.sendHelpChatInputMsg().sendKeys("Test Input");
		log.debug("Clicking Help Chat Button send");
		helpChat.getHelpChatButton().click();
		log.debug("Inputing email");
		helpChat.getHelpChatEmail().sendKeys("opeleg1990@gmail.com");
		log.debug("Clicking Help Chat Button email confirm send");
		helpChat.getHelpChatEmailSend().click();
		log.info("Verifying help chat message received");
		Assert.assertEquals(helpChat.getHelpChatInputMsgTest().getText(), "Test Input");

	}
	
	@AfterTest
	public void teardown() {

		driver.close();

	}

}
