package TelAvivHotel;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
import pageObjects.HomePageCredentials;
import pageObjects.TopNavSocialMediaLinks;
import resources.base;

public class ValidateHomePageCredentials extends base {

	public WebDriver driver;
	public HomePageCredentials homePageCredentials;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
		prop.getProperty("url");

		homePageCredentials = new HomePageCredentials(driver);
		
	}
	
	@Test

	public void validateUrl() throws IOException {
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, prop.getProperty("url"));

	}
	
	

	@Test

	public void validateTopNavCredentials() throws IOException {
		
		log.info("Verifying hotel address is correct");
		Assert.assertEquals(homePageCredentials.getTopBarAddress().getText(), prop.getProperty("hotelAddress"));

	}
	
	@Test

	public void validateBottomNavCredentials() throws IOException {
		
	log.info("Verifying hotel phone number is correct");
	Assert.assertEquals(homePageCredentials.getBottomBarCredentials().get(0), prop.getProperty("hotelPhoneNumber"));
	log.info("Verifying hotel email is correct");
	Assert.assertEquals(homePageCredentials.getBottomBarCredentials().get(1), prop.getProperty("hotelEmail"));
	log.info("Verifying hotel website is correct");
	Assert.assertEquals(homePageCredentials.getBottomBarCredentials().get(2), prop.getProperty("hotelSite"));
	log.info("Verifying hotel address is correct");
	Assert.assertEquals(homePageCredentials.getBottomBarCredentials().get(3), prop.getProperty("hotelAddress"));
	log.info("Verifying hotel hours are correct");
	Assert.assertEquals(homePageCredentials.getBottomBarCredentials().get(4), prop.getProperty("hotelHours"));
	

	}

	@Test

	public void validateHotelDescription() throws IOException {
		
		log.info("Verifying hotel Description is correct");
		Assert.assertEquals(homePageCredentials.getHotelDescription().getText(), prop.getProperty("hotelDescription"));

	}
	
	
	@AfterTest
	public void teardown() {

		driver.close();

	}

}
