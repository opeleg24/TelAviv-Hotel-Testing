package TelAvivHotel;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.TelAvivCityPage;
import resources.base;

public class ValidateTelAvivCityPage extends base {
	
	public WebDriver driver;
	public TelAvivCityPage TelAvivCityPage;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		TelAvivCityPage = new TelAvivCityPage(driver);
	}

	@Test(priority=2)

	public void validateTopTelAvivCityPageLink() throws IOException {
		log.debug("Clicking Tel Aviv City Page Link");
		TelAvivCityPage.clickTopLink().click();
		log.info("Verifying Tel Aviv City Page Top Nav");
		Assert.assertEquals(TelAvivCityPage.getPageTelAvivCityText().getText(), "TEL AVIV CITY");

	}
	
	@Test(priority=1)

	public void validateMiddleTelAvivCityPageLink() throws IOException {
		log.debug("Clicking Tel Aviv City Page Link");
		TelAvivCityPage.clickMiddleLink().click();
		log.info("Verifying Tel Aviv City Page middle Nav");
		Assert.assertEquals(TelAvivCityPage.getPageTelAvivCityText().getText(), "TEL AVIV CITY");

	}

	@Test(priority=3)

	public void validateBottomTelAvivCityPageLink() throws IOException {
		log.debug("Clicking Tel Aviv City Page Link");
		TelAvivCityPage.clickBottomLink().click();
		log.info("Verifying Tel Aviv City Page Bottom Nav");
		Assert.assertEquals(TelAvivCityPage.getPageTelAvivCityText().getText(), "TEL AVIV CITY");

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
