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
import org.testng.annotations.Test;

import pageObjects.AboutUsPage;

import pageObjects.TopNavSocialMediaLinks;
import resources.base;

public class ValidateAboutUsPage extends base {

	public WebDriver driver;
	public AboutUsPage aboutUsPage;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		aboutUsPage = new AboutUsPage(driver);

	}

	@Test(priority = 1)

	public void validateCenterAboutUsPageLink() throws IOException {
		log.debug("Clicking About Us Page Link");
		aboutUsPage.clickMiddleLink().click();
		log.info("Verifying About Us Page Center Nav");
//		aboutUsPage.waitForAboutUsText();
		Assert.assertEquals(aboutUsPage.getPageAboutUsText().getText(), "ABOUT US");

	}

	@Test(priority = 2)

	public void validateTopAboutUsPageLink() throws IOException {
		log.debug("Clicking About Us Page Link");
		aboutUsPage.clickTopLink().click();
		log.info("Verifying About Us Page Top Nav");
//		aboutUsPage.waitForAboutUsText();
		Assert.assertEquals(aboutUsPage.getPageAboutUsText().getText(), "ABOUT US");

	}

	@Test(priority = 3)

	public void validateNavAboutUsPageLink() throws IOException {
//		aboutUsPage.waitForAboutUsLink() ;
		log.debug("Clicking About Us Page Link");
		aboutUsPage.clickBottomLink().click();
		log.info("Verifying About Us Page Bottom Nav");
//		aboutUsPage.waitForAboutUsText();
		Assert.assertEquals(aboutUsPage.getPageAboutUsText().getText(), "ABOUT US");

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
