package TelAvivHotel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;

import pageObjects.TopNavSocialMediaLinks;
import resources.base;

public class ValidateContactUsPage extends base {

	public WebDriver driver;
	public ContactUsPage contactUsPage;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
		prop.getProperty("url");

		contactUsPage = new ContactUsPage(driver);
		contactUsPage.clickTopLink().click();
	}
     
	@Test

	public void validateTopContactUsPageLink() throws IOException {
		
		log.debug("Clicking Contact Us Page Page Link");
		contactUsPage.clickTopLink().click();
		log.info("Verifying Contact Us Page Top Nav");
		Assert.assertEquals(contactUsPage.getPageContactUsText().getText(), "CONTACT US");

	}

	@Test

	public void validateBottomContactUsPageLink() throws IOException {
		log.debug("Clicking Contact Us Page Link");
		contactUsPage.clickBottomLink().click();
		log.info("Verifying Contact Us Page Bottom Nav");
		Assert.assertEquals(contactUsPage.getPageContactUsText().getText(), "CONTACT US");

	}
	
	@Test

	public void validateContactUsForm() throws IOException {
		log.debug("Send name to contact us form");
		contactUsPage.getName().clear();
		contactUsPage.getName().sendKeys(prop.getProperty("name"));
		log.debug("Send email to contact us form");
		contactUsPage.getEmail().clear();
		contactUsPage.getEmail().sendKeys(prop.getProperty("email"));
		log.debug("Send subject to contact us form");
		contactUsPage.getSubject().clear();
		contactUsPage.getSubject().sendKeys(prop.getProperty("subject"));
		log.debug("Send message to contact us form");
		contactUsPage.getMessage().clear();
		contactUsPage.getMessage().sendKeys(prop.getProperty("message"));
		log.debug("Sumbit contact us form");
		contactUsPage.getSumbit().click();
		log.info("Validate Sumbit contact us form");
//		wait
		contactUsPage.waitForContactUsTextSuccessMessage();
		Assert.assertEquals(contactUsPage.getSuccessMessage().getText(),
				"Thank you for your message. It has been sent.");

	}

	@Test
	
	public void validateContactUsFormRequiredFieldsName()
			throws IOException {
		log.info("Leave name blank and all other insert input to all fields");
		contactUsPage.getName().clear();
		contactUsPage.getEmail().clear();
		contactUsPage.getEmail().sendKeys(prop.getProperty("email"));
		log.debug("Send subject to contact us form");
		contactUsPage.getSubject().clear();
		contactUsPage.getSubject().sendKeys(prop.getProperty("subject"));
		log.debug("Send message to contact us form");
		contactUsPage.getMessage().clear();
		contactUsPage.getMessage().sendKeys(prop.getProperty("message"));
		log.debug("Sumbit contact us form");
		contactUsPage.getSumbit().click();
		log.info("Error Message should appear 'The field is required' and form not be submitted");
//		wait
		contactUsPage.waitForContactUsTextFieldRequiredMessage();
		Assert.assertEquals(contactUsPage.getFieldRequiredMessage().getText(), "The field is required.");

	}

	@Test

	public void validateContactUsFormRequiredFieldsEmail()
			throws IOException {
		log.debug("Send name to contact us form");
		contactUsPage.getName().clear();
		contactUsPage.getName().sendKeys(prop.getProperty("name"));
		log.info("Leave name blank and all other insert input to all fields");
	
		log.debug("Send subject to contact us form");
		contactUsPage.getEmail().clear();
		contactUsPage.getSubject().clear();
		contactUsPage.getSubject().sendKeys(prop.getProperty("subject"));
		log.debug("Send message to contact us form");
		contactUsPage.getMessage().clear();
		contactUsPage.getMessage().sendKeys(prop.getProperty("message"));
		log.debug("Sumbit contact us form");
		contactUsPage.getSumbit().click();
		log.info("Error Message should appear 'The field is required' and form not be submitted");
//		wait
		contactUsPage.waitForContactUsTextFieldRequiredMessage();
		Assert.assertEquals(contactUsPage.getFieldRequiredMessage().getText(), "The field is required.");

	}

	@Test

	public void validateContactUsFormInvaildEmail() throws IOException {
		log.debug("Send name to contact us form");
		contactUsPage.getName().clear();
		contactUsPage.getName().sendKeys(prop.getProperty("name"));
		log.debug("send invaild email");
		contactUsPage.getEmail().clear();
		contactUsPage.getEmail().sendKeys(prop.getProperty("invaildEmail"));
		log.debug("Send subject to contact us form");
		contactUsPage.getSubject().clear();
		contactUsPage.getSubject().sendKeys(prop.getProperty("subject"));
		log.debug("Send message to contact us form");
		contactUsPage.getMessage().clear();
		contactUsPage.getMessage().sendKeys(prop.getProperty("message"));
		log.debug("Sumbit contact us form");
		contactUsPage.getSumbit().click();
		log.info("Error Message should appear 'The field is required' and form not be submitted");
//		wait
		contactUsPage.waitForContactUsTextFieldRequiredMessage();
		Assert.assertEquals(contactUsPage.getFieldRequiredMessage().getText(),
				"The e-mail address entered is invalid.");

	}

	
	@AfterTest
	public void teardown() {

		driver.close();

	}

}
